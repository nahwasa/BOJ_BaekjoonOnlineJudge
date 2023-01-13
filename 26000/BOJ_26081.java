import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        new GGANALi().run();
    }
}

class GGANALi {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1<<16);

    private void initWindow() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        Actor actor = new Actor();
        actor.name = "Window";
        actor.size = new Vector(W, H);
        actor.position = new Vector(0, 0);
        actor.parentOrigin = new Vector(0, 0);
        actor.anchorPoint = new Vector(0, 0);
        actor.color = 0;
        actor.sensitive = actor.clipChild = 1;
        ActorStorage.root = actor;
        ActorStorage.actorMap.put("Window", actor);
    }

    private void printWindow() {
        int windowX = ActorStorage.root.size.x;
        int windowY = ActorStorage.root.size.y;

        for (int i = 0; i < windowY; i++) {
            for (int j = 0; j < windowX; j++) {
                Output.answer.append(new Touch().getTouchedColor(j, i));
            }
            Output.answer.append('\n');
        }
    }

    public void run() throws Exception {
        initWindow();
        int q = Integer.parseInt(br.readLine());
        while (q-->0) {
            Order order = OrderFactory.createByInput(br.readLine());
            order.processOrder();
        }
        printWindow();
        System.out.print(Output.answer);
    }
}

class ActorStorage {
    public static final Map<String, Actor> actorMap = new HashMap<>();
    public static Actor root;

}

class Output {
    public static StringBuilder answer = new StringBuilder();
}

class Vector {
    int x, y;
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Vector() {
        this(0, 0);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

class Actor {
    String name;
    Vector position, size, parentOrigin, anchorPoint, screenPosition;
    int color, sensitive, clipChild;
    List<Actor> child;
    Actor parent;

    public Actor() {
        position = new Vector();
        size = new Vector();
        color = 1;
        parentOrigin = new Vector();
        anchorPoint = new Vector();
        sensitive = 1;
        clipChild = 0;
        screenPosition = new Vector();
        child = new ArrayList<>();
    }

    public void screenPositionSetup() {
        List<Actor> path = new ArrayList<>();
        path.add(this);
        Actor root = this;
        while (root != null && root != ActorStorage.root) {
            root = root.parent;
            path.add(root);
        }
        if (root == null) {
            screenPosition = new Vector(0, 0);
            return;
        }

        int xs, xe, ys, ye;
        xs=xe=ys=ye=0;
        for (int i = path.size()-1; i >= 0; i--) {
            Actor cur = path.get(i);
            int anchorX = cur.position.x + (cur.parentOrigin.x == 0 ? xs : xe);
            int anchorY = cur.position.y + (cur.parentOrigin.y == 0 ? ys : ye);

            if (cur == this) {
                this.screenPosition = new Vector(anchorX, anchorY);
                break;
            }

            if (cur.anchorPoint.x == 0) {
                xs = anchorX;
                xe = anchorX + cur.size.x;
            } else {
                xs = anchorX - cur.size.x;
                xe = anchorX;
            }
            if (cur.anchorPoint.y == 0) {
                ys = anchorY;
                ye = anchorY + cur.size.y;
            } else {
                ys = anchorY - cur.size.y;
                ye = anchorY;
            }
            if (xs > xe) {
                int tmp = xe;
                xe = xs;
                xs = tmp;
            }
            if (ys > ye) {
                int tmp = ye;
                ye = ys;
                ys = tmp;
            }
        }
    }

    public void addChild(Actor childActor) {
        child.add(childActor);
        childActor.parent = this;
    }

    private void removeChild(Actor childActor) {
        child.remove(childActor);
    }

    public void removeParent() {
        if (parent == null) return;
        parent.removeChild(this);
        parent = null;
    }
}

class OrderFactory {
    public static Order createByInput(String s) throws Exception {
        StringTokenizer st = new StringTokenizer(s);
        String orderName = st.nextToken();
        Order order = null;
        switch (orderName) {
            case "New": order = new New(); break;
            case "Add": order = new Add(); break;
            case "Remove": order = new Remove(); break;
            case "Unparent": order = new Unparent(); break;
            case "SetProperty": order = new SetProperty(); break;
            case "GetProperty": order = new GetProperty(); break;
            case "Touch": order = new Touch(); break;

        }
        order.st = st;
        return order;
    }
}

abstract class Order {
    protected StringTokenizer st;

    public void processOrder() {
        initParameters();
        process();
        st = null;
    }

    public abstract void initParameters();
    public abstract void process();
}

class New extends Order {
    String actorName;

    @Override
    public void initParameters() {
        this.actorName = st.nextToken();
    }

    @Override
    public void process() {
        Actor actor = new Actor();
        actor.name = actorName;
        ActorStorage.actorMap.put(actorName, actor);
    }
}

class Add extends Order {
    String actorName, childName;

    @Override
    public void initParameters() {
        this.actorName = st.nextToken();
        this.childName = st.nextToken();
    }

    @Override
    public void process() {
        Actor parent = ActorStorage.actorMap.get(actorName);
        Actor child = ActorStorage.actorMap.get(childName);
        child.removeParent();
        parent.addChild(child);
    }
}

class Remove extends Order {
    String actorName;
    String removeFrom;

    @Override
    public void initParameters() {
        this.actorName = st.nextToken();
        this.removeFrom = st.nextToken();
    }

    @Override
    public void process() {
        Actor parent = ActorStorage.actorMap.get(actorName);
        Actor child = ActorStorage.actorMap.get(removeFrom);
        if (child.parent == null || !child.parent.equals(parent)) return;
        child.removeParent();
    }
}

class Unparent extends Order {
    String actorName;

    @Override
    public void initParameters() {
        this.actorName = st.nextToken();
    }

    @Override
    public void process() {
        Actor child = ActorStorage.actorMap.get(actorName);
        child.removeParent();
    }
}

class SetProperty extends Order {
    String actorName, propertyName;
    boolean isVector;
    int v;
    Vector vector;

    @Override
    public void initParameters() {
        actorName = st.nextToken();
        propertyName = st.nextToken();
        String a = st.nextToken();
        if (st.hasMoreTokens()) {
            String b = st.nextToken();
            isVector = true;
            vector = new Vector(Integer.parseInt(a), Integer.parseInt(b));
        } else {
            isVector = false;
            v = Integer.parseInt(a);
        }
    }

    @Override
    public void process() {
        Actor actor = ActorStorage.actorMap.get(actorName);
        switch (propertyName) {
            case "POSITION": actor.position = vector; break;
            case "SIZE": actor.size = vector; break;
            case "COLOR": actor.color = v; break;
            case "PARENT_ORIGIN": actor.parentOrigin = vector; break;
            case "ANCHOR_POINT": actor.anchorPoint = vector; break;
            case "CLIP_CHILD": actor.clipChild = v; break;
            case "SENSITIVE": actor.sensitive = v; break;
        }
    }
}

class GetProperty extends Order {
    String actorName, propertyName;

    @Override
    public void initParameters() {
        this.actorName = st.nextToken();
        this.propertyName = st.nextToken();
    }

    @Override
    public void process() {
        Actor actor = ActorStorage.actorMap.get(actorName);
        switch (propertyName) {
            case "POSITION": Output.answer.append(actor.position); break;
            case "SIZE": Output.answer.append(actor.size); break;
            case "COLOR": Output.answer.append(actor.color); break;
            case "PARENT_ORIGIN": Output.answer.append(actor.parentOrigin); break;
            case "ANCHOR_POINT": Output.answer.append(actor.anchorPoint); break;
            case "CLIP_CHILD": Output.answer.append(actor.clipChild); break;
            case "SENSITIVE": Output.answer.append(actor.sensitive); break;
            case "SCREEN_POSITION": actor.screenPositionSetup(); Output.answer.append(actor.screenPosition); break;
        }
        Output.answer.append('\n');
    }
}

class Touch extends Order {
    int touchX, touchY;
    boolean checkSensitiveDuringSearch;
    Actor searchResult = null;

    @Override
    public void initParameters() {
        touchX = Integer.parseInt(st.nextToken());
        touchY = Integer.parseInt(st.nextToken());
        checkSensitiveDuringSearch = true;
    }

    class Rectangle {
        int xs, xe, ys, ye;

        public Rectangle() {
            this(0,0,0,0);
        }

        public Rectangle(int xs, int xe, int ys, int ye) {
            this.xs = xs;
            this.xe = xe;
            this.ys = ys;
            this.ye = ye;
        }

        public boolean contains() {
            return xs<=touchX && xe>touchX && ys<=touchY && ye>touchY;
        }
    }

    private Rectangle createRectangle(int anchorX, int anchorY, Actor cur) {
        Rectangle rec = new Rectangle();
        if (cur.anchorPoint.x == 0) {
            rec.xs = anchorX;
            rec.xe = anchorX + cur.size.x;
        } else {
            rec.xs = anchorX - cur.size.x;
            rec.xe = anchorX;
        }
        if (cur.anchorPoint.y == 0) {
            rec.ys = anchorY;
            rec.ye = anchorY + cur.size.y;
        } else {
            rec.ys = anchorY - cur.size.y;
            rec.ye = anchorY;
        }
        if (rec.xs > rec.xe) {
            int tmp = rec.xe;
            rec.xe = rec.xs;
            rec.xs = tmp;
        }
        if (rec.ys > rec.ye) {
            int tmp = rec.ye;
            rec.ye = rec.ys;
            rec.ys = tmp;
        }
        return rec;
    }

    public Rectangle createClipRect(Rectangle clip, Rectangle curRect) {
        Rectangle result = new Rectangle();
        result.xs = Math.max(clip.xs, curRect.xs);
        result.xe = Math.min(clip.xe, curRect.xe);
        result.ys = Math.max(clip.ys, curRect.ys);
        result.ye = Math.min(clip.ye, curRect.ye);
        return result;
    }


    public void search(Actor cur, Rectangle parent, Rectangle clip) {
        if (clip.xs > touchX || clip.xe < touchX || clip.ys > touchY || clip.ye < touchY) return;

        int anchorX = cur.position.x + (cur.parentOrigin.x == 0 ? parent.xs : parent.xe);
        int anchorY = cur.position.y + (cur.parentOrigin.y == 0 ? parent.ys : parent.ye);
        Rectangle curRect = createRectangle(anchorX, anchorY, cur);
        Rectangle curClip = clip;
        if (cur.clipChild == 1) {
            curClip = createClipRect(clip, curRect);
        }

        for (int i = cur.child.size()-1; searchResult == null && i >= 0; i--) {
            Actor next = cur.child.get(i);
            search(next, curRect, curClip);
        }

        if (searchResult != null)
            return;
        if (curRect.contains() && curClip.contains() && (cur.sensitive == 1 || !checkSensitiveDuringSearch))
            searchResult = cur;
    }

    @Override
    public void process() {
        search(ActorStorage.root, new Rectangle(), new Rectangle(-10000, 100000, -100000, 100000));
        if (searchResult == null)
            searchResult = ActorStorage.root;
        Output.answer.append(searchResult.name).append('\n');
    }

    public int getTouchedColor(int x, int y) {
        this.checkSensitiveDuringSearch = false;
        this.touchX = x;
        this.touchY = y;
        search(ActorStorage.root, new Rectangle(), new Rectangle(-10000, 100000, -100000, 100000));
        if (searchResult == null)
            searchResult = ActorStorage.root;
        return searchResult.color;
    }
}

