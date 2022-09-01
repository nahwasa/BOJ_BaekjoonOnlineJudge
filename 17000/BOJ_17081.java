import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TerrainTrap extends Terrain {
    public TerrainTrap() {
        type = MapObject.TYPE_TERRAIN_TRAP;
    }

    @Override
    public ProcResult proc(Player player) {
        player.hit(player.isAccessaryExist(EquipAccessory.DX)?1:5);
        return new ProcResult(player.isPlayerDead(), false, true, "SPIKE TRAP");
    }
}


class TerrainBlock extends Terrain {
    public TerrainBlock() {
        type = MapObject.TYPE_TERRAIN_BLOCK;
    }

    @Override
    public ProcResult proc(Player player) {
        return new ProcResult(false, false, false);
    }
}


class TerrainBlank extends Terrain {
    public TerrainBlank() {
        type = MapObject.TYPE_TERRAIN_BLANK;
    }

    @Override
    public ProcResult proc(Player player) {
        return new ProcResult();
    }
}


abstract class Terrain extends MapObject {
}


class ProcResult {
    boolean isGameEnded;
    boolean isObjCleared;
    boolean moveConfirmed;
    String playerKillerName;

    public ProcResult() {
        this(false, false, true);
    }

    public ProcResult(boolean isObjCleared) {
        this();
        this.isObjCleared = isObjCleared;
    }

    public ProcResult(boolean isGameEnded, boolean isObjCleared, boolean moveConfirmed) {
        this(isGameEnded, isObjCleared, moveConfirmed, null);
    }

    public ProcResult(boolean isGameEnded, boolean isObjCleared, boolean moveConfirmed, String playerKillerName) {
        this.isGameEnded = isGameEnded;
        this.isObjCleared = isObjCleared;
        this.moveConfirmed = moveConfirmed;
        this.playerKillerName = playerKillerName;
    }
}


class Player {
    int lv;
    int curHp;
    int maxHp;
    int att;
    int def;
    int exp;
    EquipWeapon weapon;
    EquipArmor armor;
    EquipAccessory[] accessories;
    int accessoryCnt;

    public Player() {
        lv = 1;
        curHp = maxHp = 20;
        att = def = 2;
        exp = 0;
        weapon = new EquipWeapon(0);
        armor = new EquipArmor(0);
        accessories = new EquipAccessory[7];
        accessoryCnt = 0;
    }

    public int getAtt() {return this.att + weapon.att;}
    public int getDef() {return this.def + armor.def;}
    public int getWeaponAtt() {return weapon==null?0:weapon.att;}
    public int getArmorDef() {return armor==null?0:armor.def;}
    public void revive() {curHp = maxHp;}
    public boolean isAccessaryExist(int accNum) {return accessories[accNum]!=null;}
    public boolean isPlayerDead() {return curHp<=0;}

    public void hit(int dmg) {
        curHp -= dmg;
        if (curHp < 0)
            curHp = 0;
    }

    public void addAccessary(EquipAccessory accessary) {
        if (accessoryCnt == 4 || isAccessaryExist(accessary.accNum)) return;
        accessories[accessary.accNum] = accessary;
        accessoryCnt++;
    }

    public void removeAccessary(int accNum) {
        accessories[accNum] = null;
        accessoryCnt--;
    }

    public void win(Enemy enemy) {
        int need = lv*5;
        int gainedExp = enemy.exp;
        if (isAccessaryExist(EquipAccessory.EX)) {
            gainedExp = (int) (gainedExp * 1.2d);
        }
        exp += gainedExp;
        if (exp >= need) {
            exp = 0;
            lvUp();
        }

        if (isAccessaryExist(EquipAccessory.HR)) {
            curHp += 3;
            if (maxHp < curHp)
                curHp = maxHp;
        }
    }

    public void lvUp() {
        lv++;
        maxHp+=5;
        curHp = maxHp;
        att+=2;
        def+=2;
    }
}

abstract class MapObject {
    public static final int TYPE_EMENY = 1;
    public static final int TYPE_EMENY_BOSS = 2;
    public static final int TYPE_TERRAIN_BLOCK = 3;
    public static final int TYPE_TERRAIN_BLANK = 4;
    public static final int TYPE_TERRAIN_TRAP = 5;

    int r, c, type = -1;

    public boolean isEnemy() {
        return type == TYPE_EMENY || type == TYPE_EMENY_BOSS;
    }
    public boolean isBossEnemy() {return type == TYPE_EMENY_BOSS;}
    public boolean isBlank() {return type == TYPE_TERRAIN_BLANK;}
    public boolean isBlock() {return type == TYPE_TERRAIN_BLOCK;}
    public boolean isTrap() {return type == TYPE_TERRAIN_TRAP;}

    public abstract ProcResult proc(Player player);
}


class EquipWeapon extends Equipment {
    int att;

    public EquipWeapon(int att) {
        this.att = att;
    }

    @Override
    public ProcResult proc(Player player) {
        player.weapon = this;
        return super.proc(player);
    }
}

abstract class Equipment extends MapObject {
    @Override
    public ProcResult proc(Player player) {
        return new ProcResult(false, true, true);
    }
}


class EquipArmor extends Equipment {
    int def;

    public EquipArmor(int def) {
        this.def = def;
    }

    @Override
    public ProcResult proc(Player player) {
        player.armor = this;
        return super.proc(player);
    }
}


class EquipAccessory extends Equipment {
    public static final int HR = 0;
    public static final int RE = 1;
    public static final int CO = 2;
    public static final int EX = 3;
    public static final int DX = 4;
    public static final int HU = 5;
    public static final int CU = 6;

    public int accNum;

    private static int getAccNum(String type) {
        switch (type) {
            case "CO": return EquipAccessory.CO;
            case "CU": return EquipAccessory.CU;
            case "DX": return EquipAccessory.DX;
            case "EX": return EquipAccessory.EX;
            case "HR": return EquipAccessory.HR;
            case "HU": return EquipAccessory.HU;
            case "RE": return EquipAccessory.RE;
        }
        return -1;
    }

    public EquipAccessory(String type) {
        accNum = getAccNum(type);
    }

    @Override
    public ProcResult proc(Player player) {
        player.addAccessary(this);
        return super.proc(player);
    }
}


class Enemy extends MapObject {
    String name;
    int att;
    int def;
    int curHp;
    int maxHp;
    int exp;

    public Enemy(StringTokenizer st, boolean isBoss) {
        name = st.nextToken();
        att = Integer.parseInt(st.nextToken());
        def = Integer.parseInt(st.nextToken());
        maxHp = curHp = Integer.parseInt(st.nextToken());
        exp = Integer.parseInt(st.nextToken());
        type = isBoss ? MapObject.TYPE_EMENY_BOSS : MapObject.TYPE_EMENY;
    }

    public void revive() {
        curHp = maxHp;
    }

    private boolean isDead() {
        return curHp<=0;
    }

    private void hit(int dmg) {
        curHp -= dmg;
        if (curHp < 0)
            curHp = 0;
    }

    @Override
    public ProcResult proc(Player player) {
        boolean isFirstAtkFromPlayer = true;
        boolean isFirstAtkToPlayer = true;
        int playerAtk = player.getAtt();
        int playerDef = player.getDef();

        if (isBossEnemy() && player.isAccessaryExist(EquipAccessory.HU))
            player.revive();


        int cnt = 0;
        while (!player.isPlayerDead() && !isDead()) {
            if (cnt++ % 2 == 0) {
                int dmgFromPlayer = Math.max(1, playerAtk - def);
                if (isFirstAtkFromPlayer) {
                    if (player.isAccessaryExist(EquipAccessory.CO))
                        dmgFromPlayer = Math.max(1, playerAtk * (player.isAccessaryExist(EquipAccessory.DX) ? 3 : 2) - def);
                    isFirstAtkFromPlayer = false;
                }
                hit(dmgFromPlayer);
            } else {
                int dmgToPlayer = Math.max(1, att - playerDef);
                if (isFirstAtkToPlayer) {
                    if (isBossEnemy() && player.isAccessaryExist(EquipAccessory.HU))
                        dmgToPlayer = 0;
                    isFirstAtkToPlayer = false;
                }
                player.hit(dmgToPlayer);
            }
        }

        if (!player.isPlayerDead()) {   // player win
            player.win(this);
            return new ProcResult(isBossEnemy(), true, true);
        } else {
            return new ProcResult(true, false, false, name);
        }
    }
}


class RPGExtreme implements Runnable {
    @Override
    public void run() {
        try {
            solution();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final int[] DR = {-1,0,1,0};
    private static final int[] DC = {0,1,0,-1};
    MapObject[][] map;
    char[][] originalMap;
    Player player = new Player();
    int r, c, pr, pc, basePr, basePc, bossR, bossC;
    int[] move;
    int turn = 0;


    private void solution() throws Exception {
        initGame();
        for (int i = 0; i < move.length; i++) {
            turn++;

            int nr = pr + DR[move[i]];
            int nc = pc + DC[move[i]];
            if (nr < 0 || nr >= r || nc < 0 || nc >= c || map[nr][nc].isBlock()) {
                nr = pr;
                nc = pc;
            }

            MapObject curObj = map[nr][nc];
            ProcResult procResult = curObj.proc(player);
            pr = nr;
            pc = nc;
            if (procResult.moveConfirmed) {
                pr = nr;
                pc = nc;
            }
            if (procResult.isObjCleared) {
                map[nr][nc] = new TerrainBlank();
            }

            if (!procResult.isGameEnded) continue;

            if (player.isPlayerDead()) {
                // for Accessary 'RE'
                if (player.isAccessaryExist(EquipAccessory.RE)) {
                    player.removeAccessary(EquipAccessory.RE);
                    player.revive();
                    pr = basePr;
                    pc = basePc;
                    if (curObj.isEnemy())
                        ((Enemy)curObj).revive();
                    continue;
                }

                gameEnd(true, procResult);
                return;
            } else {
                gameEnd(false, procResult);
                return;
            }
        }
        gameEnd(false, null);
    }

    private void gameEnd(boolean isPlayerDead, ProcResult procResult) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (!isPlayerDead && i == pr && j == pc) {
                    sb.append('@');
                    continue;
                }

                sb.append(map[i][j].isBlank() ? '.' : originalMap[i][j]);

            }
            sb.append('\n');
        }
        sb.append("Passed Turns : ").append(turn).append('\n');
        sb.append("LV : ").append(player.lv).append('\n');
        sb.append("HP : ").append(player.curHp<0?0:player.curHp).append('/').append(player.maxHp).append('\n');
        sb.append("ATT : ").append(player.att).append('+').append(player.getWeaponAtt()).append('\n');
        sb.append("DEF : ").append(player.def).append('+').append(player.getArmorDef()).append('\n');
        sb.append("EXP : ").append(player.exp).append('/').append(player.lv*5).append('\n');
        if (!isPlayerDead && !map[bossR][bossC].isBossEnemy()) {
            sb.append("YOU WIN!");
        } else if (!isPlayerDead) {
            sb.append("Press any key to continue.");
        } else {
            sb.append("YOU HAVE BEEN KILLED BY ").append(procResult.playerKillerName).append('.').append('.');
        }
        System.out.println(sb);
    }

    private void initGame() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new MapObject[r][c];
        originalMap = new char[r][c];
        int enemyCnt = 0;
        int equipCnt = 0;
        for (int i = 0; i < r; i++) {
            String row = br.readLine();
            for (int j = 0; j < c; j++) {
                char c = row.charAt(j);
                originalMap[i][j] = c;
                switch (c) {
                    case '@': basePr=pr=i; basePc=pc=j; originalMap[i][j] = '.';   // mapObject of position '@' is 'TerrainBlank'
                    case '.': map[i][j] = new TerrainBlank(); break;
                    case '#': map[i][j] = new TerrainBlock(); break;
                    case '^': map[i][j] = new TerrainTrap(); break;
                    case 'M': bossR=i; bossC=j;
                    case '&': enemyCnt++; break;
                    case 'B': equipCnt++; break;
                }
            }
        }

        String moveStr = br.readLine();
        move = new int[moveStr.length()];
        for (int i = 0; i < moveStr.length(); i++) {
            switch (moveStr.charAt(i)) {
                case 'U': move[i] = 0; break;
                case 'R': move[i] = 1; break;
                case 'D': move[i] = 2; break;
                case 'L': move[i] = 3; break;
            }
        }

        while (enemyCnt-->0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            Enemy enemy = new Enemy(st, bossR == i && bossC == j);

            map[i][j] = enemy;
        }

        while (equipCnt-->0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            switch (st.nextToken().charAt(0)) {
                case 'W': map[i][j] = new EquipWeapon(Integer.parseInt(st.nextToken())); break;
                case 'A': map[i][j] = new EquipArmor(Integer.parseInt(st.nextToken())); break;
                case 'O': map[i][j] = new EquipAccessory(st.nextToken()); break;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                map[i][j].r = i;
                map[i][j].c = j;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new RPGExtreme().run();
    }
}
