import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String data = PokemonBook.data;
		String dst = br.readLine();
		StringTokenizer st = new StringTokenizer(data, "\n");
		while(st.hasMoreTokens()) {
			if (st.nextToken().contains(dst)) {
				bw.write(st.nextToken() + "\n");
				StringTokenizer tmp = new StringTokenizer(st.nextToken(), " ·");
				while (tmp.hasMoreTokens())
					bw.write(tmp.nextToken() + (tmp.hasMoreTokens()?" ":""));
				bw.newLine();
				break;
			}
		}
		bw.flush();
		br.close();
		bw.close();		
	}
}

class PokemonBook {
	static String data = "#001\n" + 
			"Bulbasaur\n" + 
			"Grass · Poison \n" + 
			"#002\n" + 
			"Ivysaur\n" + 
			"Grass · Poison \n" + 
			"#003\n" + 
			"Venusaur\n" + 
			"Grass · Poison \n" + 
			"#004\n" + 
			"Charmander\n" + 
			"Fire \n" + 
			"#005\n" + 
			"Charmeleon\n" + 
			"Fire \n" + 
			"#006\n" + 
			"Charizard\n" + 
			"Fire · Flying \n" + 
			"#007\n" + 
			"Squirtle\n" + 
			"Water\n" + 
			"#008\n" + 
			"Wartortle\n" + 
			"Water \n" + 
			"#009\n" + 
			"Blastoise\n" + 
			"Water \n" + 
			"#010\n" + 
			"Caterpie\n" + 
			"Bug \n" + 
			"#011\n" + 
			"Metapod\n" + 
			"Bug \n" + 
			"#012\n" + 
			"Butterfree\n" + 
			"Bug · Flying \n" + 
			"#013\n" + 
			"Weedle\n" + 
			"Bug · Poison \n" + 
			"#014\n" + 
			"Kakuna\n" + 
			"Bug · Poison\n" + 
			"#015\n" + 
			"Beedrill\n" + 
			"Bug · Poison \n" + 
			"#016\n" + 
			"Pidgey\n" + 
			"Normal · Flying \n" + 
			"#017\n" + 
			"Pidgeotto\n" + 
			"Normal · Flying \n" + 
			"#018\n" + 
			"Pidgeot\n" + 
			"Normal · Flying \n" + 
			"#019\n" + 
			"Rattata\n" + 
			"Normal \n" + 
			"#020\n" + 
			"Raticate\n" + 
			"Normal \n" + 
			"#021\n" + 
			"Spearow\n" + 
			"Normal · Flying\n" + 
			"#022\n" + 
			"Fearow\n" + 
			"Normal · Flying \n" + 
			"#023\n" + 
			"Ekans\n" + 
			"Poison \n" + 
			"#024\n" + 
			"Arbok\n" + 
			"Poison \n" + 
			"#025\n" + 
			"Pikachu\n" + 
			"Electric \n" + 
			"#026\n" + 
			"Raichu\n" + 
			"Electric \n" + 
			"#027\n" + 
			"Sandshrew\n" + 
			"Ground \n" + 
			"#028\n" + 
			"Sandslash\n" + 
			"Ground\n" + 
			"#029\n" + 
			"Nidoran♀\n" + 
			"Poison \n" + 
			"#030\n" + 
			"Nidorina\n" + 
			"Poison \n" + 
			"#031\n" + 
			"Nidoqueen\n" + 
			"Poison · Ground \n" + 
			"#032\n" + 
			"Nidoran♂\n" + 
			"Poison \n" + 
			"#033\n" + 
			"Nidorino\n" + 
			"Poison \n" + 
			"#034\n" + 
			"Nidoking\n" + 
			"Poison · Ground \n" + 
			"#035\n" + 
			"Clefairy\n" + 
			"Fairy\n" + 
			"#036\n" + 
			"Clefable\n" + 
			"Fairy \n" + 
			"#037\n" + 
			"Vulpix\n" + 
			"Fire \n" + 
			"#038\n" + 
			"Ninetales\n" + 
			"Fire \n" + 
			"#039\n" + 
			"Jigglypuff\n" + 
			"Normal · Fairy \n" + 
			"#040\n" + 
			"Wigglytuff\n" + 
			"Normal · Fairy \n" + 
			"#041\n" + 
			"Zubat\n" + 
			"Poison · Flying \n" + 
			"#042\n" + 
			"Golbat\n" + 
			"Poison · Flying\n" + 
			"#043\n" + 
			"Oddish\n" + 
			"Grass · Poison \n" + 
			"#044\n" + 
			"Gloom\n" + 
			"Grass · Poison \n" + 
			"#045\n" + 
			"Vileplume\n" + 
			"Grass · Poison \n" + 
			"#046\n" + 
			"Paras\n" + 
			"Bug · Grass \n" + 
			"#047\n" + 
			"Parasect\n" + 
			"Bug · Grass \n" + 
			"#048\n" + 
			"Venonat\n" + 
			"Bug · Poison \n" + 
			"#049\n" + 
			"Venomoth\n" + 
			"Bug · Poison\n" + 
			"#050\n" + 
			"Diglett\n" + 
			"Ground \n" + 
			"#051\n" + 
			"Dugtrio\n" + 
			"Ground \n" + 
			"#052\n" + 
			"Meowth\n" + 
			"Normal \n" + 
			"#053\n" + 
			"Persian\n" + 
			"Normal \n" + 
			"#054\n" + 
			"Psyduck\n" + 
			"Water \n" + 
			"#055\n" + 
			"Golduck\n" + 
			"Water \n" + 
			"#056\n" + 
			"Mankey\n" + 
			"Fighting\n" + 
			"#057\n" + 
			"Primeape\n" + 
			"Fighting \n" + 
			"#058\n" + 
			"Growlithe\n" + 
			"Fire \n" + 
			"#059\n" + 
			"Arcanine\n" + 
			"Fire \n" + 
			"#060\n" + 
			"Poliwag\n" + 
			"Water \n" + 
			"#061\n" + 
			"Poliwhirl\n" + 
			"Water \n" + 
			"#062\n" + 
			"Poliwrath\n" + 
			"Water · Fighting \n" + 
			"#063\n" + 
			"Abra\n" + 
			"Psychic\n" + 
			"#064\n" + 
			"Kadabra\n" + 
			"Psychic \n" + 
			"#065\n" + 
			"Alakazam\n" + 
			"Psychic \n" + 
			"#066\n" + 
			"Machop\n" + 
			"Fighting \n" + 
			"#067\n" + 
			"Machoke\n" + 
			"Fighting \n" + 
			"#068\n" + 
			"Machamp\n" + 
			"Fighting \n" + 
			"#069\n" + 
			"Bellsprout\n" + 
			"Grass · Poison \n" + 
			"#070\n" + 
			"Weepinbell\n" + 
			"Grass · Poison\n" + 
			"#071\n" + 
			"Victreebel\n" + 
			"Grass · Poison \n" + 
			"#072\n" + 
			"Tentacool\n" + 
			"Water · Poison \n" + 
			"#073\n" + 
			"Tentacruel\n" + 
			"Water · Poison \n" + 
			"#074\n" + 
			"Geodude\n" + 
			"Rock · Ground \n" + 
			"#075\n" + 
			"Graveler\n" + 
			"Rock · Ground \n" + 
			"#076\n" + 
			"Golem\n" + 
			"Rock · Ground \n" + 
			"#077\n" + 
			"Ponyta\n" + 
			"Fire\n" + 
			"#078\n" + 
			"Rapidash\n" + 
			"Fire \n" + 
			"#079\n" + 
			"Slowpoke\n" + 
			"Water · Psychic \n" + 
			"#080\n" + 
			"Slowbro\n" + 
			"Water · Psychic \n" + 
			"#081\n" + 
			"Magnemite\n" + 
			"Electric · Steel \n" + 
			"#082\n" + 
			"Magneton\n" + 
			"Electric · Steel \n" + 
			"#083\n" + 
			"Farfetch'd\n" + 
			"Normal · Flying \n" + 
			"#084\n" + 
			"Doduo\n" + 
			"Normal · Flying\n" + 
			"#085\n" + 
			"Dodrio\n" + 
			"Normal · Flying \n" + 
			"#086\n" + 
			"Seel\n" + 
			"Water \n" + 
			"#087\n" + 
			"Dewgong\n" + 
			"Water · Ice \n" + 
			"#088\n" + 
			"Grimer\n" + 
			"Poison \n" + 
			"#089\n" + 
			"Muk\n" + 
			"Poison \n" + 
			"#090\n" + 
			"Shellder\n" + 
			"Water \n" + 
			"#091\n" + 
			"Cloyster\n" + 
			"Water · Ice\n" + 
			"#092\n" + 
			"Gastly\n" + 
			"Ghost · Poison \n" + 
			"#093\n" + 
			"Haunter\n" + 
			"Ghost · Poison \n" + 
			"#094\n" + 
			"Gengar\n" + 
			"Ghost · Poison \n" + 
			"#095\n" + 
			"Onix\n" + 
			"Rock · Ground \n" + 
			"#096\n" + 
			"Drowzee\n" + 
			"Psychic \n" + 
			"#097\n" + 
			"Hypno\n" + 
			"Psychic \n" + 
			"#098\n" + 
			"Krabby\n" + 
			"Water\n" + 
			"#099\n" + 
			"Kingler\n" + 
			"Water \n" + 
			"#100\n" + 
			"Voltorb\n" + 
			"Electric \n" + 
			"#101\n" + 
			"Electrode\n" + 
			"Electric \n" + 
			"#102\n" + 
			"Exeggcute\n" + 
			"Grass · Psychic \n" + 
			"#103\n" + 
			"Exeggutor\n" + 
			"Grass · Psychic \n" + 
			"#104\n" + 
			"Cubone\n" + 
			"Ground \n" + 
			"#105\n" + 
			"Marowak\n" + 
			"Ground\n" + 
			"#106\n" + 
			"Hitmonlee\n" + 
			"Fighting \n" + 
			"#107\n" + 
			"Hitmonchan\n" + 
			"Fighting \n" + 
			"#108\n" + 
			"Lickitung\n" + 
			"Normal \n" + 
			"#109\n" + 
			"Koffing\n" + 
			"Poison \n" + 
			"#110\n" + 
			"Weezing\n" + 
			"Poison \n" + 
			"#111\n" + 
			"Rhyhorn\n" + 
			"Ground · Rock \n" + 
			"#112\n" + 
			"Rhydon\n" + 
			"Ground · Rock\n" + 
			"#113\n" + 
			"Chansey\n" + 
			"Normal \n" + 
			"#114\n" + 
			"Tangela\n" + 
			"Grass \n" + 
			"#115\n" + 
			"Kangaskhan\n" + 
			"Normal \n" + 
			"#116\n" + 
			"Horsea\n" + 
			"Water \n" + 
			"#117\n" + 
			"Seadra\n" + 
			"Water \n" + 
			"#118\n" + 
			"Goldeen\n" + 
			"Water \n" + 
			"#119\n" + 
			"Seaking\n" + 
			"Water\n" + 
			"#120\n" + 
			"Staryu\n" + 
			"Water \n" + 
			"#121\n" + 
			"Starmie\n" + 
			"Water · Psychic \n" + 
			"#122\n" + 
			"Mr. Mime\n" + 
			"Psychic · Fairy \n" + 
			"#123\n" + 
			"Scyther\n" + 
			"Bug · Flying \n" + 
			"#124\n" + 
			"Jynx\n" + 
			"Ice · Psychic \n" + 
			"#125\n" + 
			"Electabuzz\n" + 
			"Electric \n" + 
			"#126\n" + 
			"Magmar\n" + 
			"Fire\n" + 
			"#127\n" + 
			"Pinsir\n" + 
			"Bug \n" + 
			"#128\n" + 
			"Tauros\n" + 
			"Normal \n" + 
			"#129\n" + 
			"Magikarp\n" + 
			"Water \n" + 
			"#130\n" + 
			"Gyarados\n" + 
			"Water · Flying \n" + 
			"#131\n" + 
			"Lapras\n" + 
			"Water · Ice \n" + 
			"#132\n" + 
			"Ditto\n" + 
			"Normal \n" + 
			"#133\n" + 
			"Eevee\n" + 
			"Normal\n" + 
			"#134\n" + 
			"Vaporeon\n" + 
			"Water \n" + 
			"#135\n" + 
			"Jolteon\n" + 
			"Electric \n" + 
			"#136\n" + 
			"Flareon\n" + 
			"Fire \n" + 
			"#137\n" + 
			"Porygon\n" + 
			"Normal \n" + 
			"#138\n" + 
			"Omanyte\n" + 
			"Rock · Water \n" + 
			"#139\n" + 
			"Omastar\n" + 
			"Rock · Water \n" + 
			"#140\n" + 
			"Kabuto\n" + 
			"Rock · Water\n" + 
			"#141\n" + 
			"Kabutops\n" + 
			"Rock · Water \n" + 
			"#142\n" + 
			"Aerodactyl\n" + 
			"Rock · Flying \n" + 
			"#143\n" + 
			"Snorlax\n" + 
			"Normal \n" + 
			"#144\n" + 
			"Articuno\n" + 
			"Ice · Flying \n" + 
			"#145\n" + 
			"Zapdos\n" + 
			"Electric · Flying \n" + 
			"#146\n" + 
			"Moltres\n" + 
			"Fire · Flying \n" + 
			"#147\n" + 
			"Dratini\n" + 
			"Dragon\n" + 
			"#148\n" + 
			"Dragonair\n" + 
			"Dragon \n" + 
			"#149\n" + 
			"Dragonite\n" + 
			"Dragon · Flying \n" + 
			"#150\n" + 
			"Mewtwo\n" + 
			"Psychic \n" + 
			"#151\n" + 
			"Mew\n" + 
			"Psychic\n" + 
			"Generation 2 Pokémon\n" + 
			"\n" + 
			"#152\n" + 
			"Chikorita\n" + 
			"Grass \n" + 
			"#153\n" + 
			"Bayleef\n" + 
			"Grass \n" + 
			"#154\n" + 
			"Meganium\n" + 
			"Grass \n" + 
			"#155\n" + 
			"Cyndaquil\n" + 
			"Fire \n" + 
			"#156\n" + 
			"Quilava\n" + 
			"Fire \n" + 
			"#157\n" + 
			"Typhlosion\n" + 
			"Fire \n" + 
			"#158\n" + 
			"Totodile\n" + 
			"Water\n" + 
			"#159\n" + 
			"Croconaw\n" + 
			"Water \n" + 
			"#160\n" + 
			"Feraligatr\n" + 
			"Water \n" + 
			"#161\n" + 
			"Sentret\n" + 
			"Normal \n" + 
			"#162\n" + 
			"Furret\n" + 
			"Normal \n" + 
			"#163\n" + 
			"Hoothoot\n" + 
			"Normal · Flying \n" + 
			"#164\n" + 
			"Noctowl\n" + 
			"Normal · Flying \n" + 
			"#165\n" + 
			"Ledyba\n" + 
			"Bug · Flying\n" + 
			"#166\n" + 
			"Ledian\n" + 
			"Bug · Flying \n" + 
			"#167\n" + 
			"Spinarak\n" + 
			"Bug · Poison \n" + 
			"#168\n" + 
			"Ariados\n" + 
			"Bug · Poison \n" + 
			"#169\n" + 
			"Crobat\n" + 
			"Poison · Flying \n" + 
			"#170\n" + 
			"Chinchou\n" + 
			"Water · Electric \n" + 
			"#171\n" + 
			"Lanturn\n" + 
			"Water · Electric \n" + 
			"#172\n" + 
			"Pichu\n" + 
			"Electric\n" + 
			"#173\n" + 
			"Cleffa\n" + 
			"Fairy \n" + 
			"#174\n" + 
			"Igglybuff\n" + 
			"Normal · Fairy \n" + 
			"#175\n" + 
			"Togepi\n" + 
			"Fairy \n" + 
			"#176\n" + 
			"Togetic\n" + 
			"Fairy · Flying \n" + 
			"#177\n" + 
			"Natu\n" + 
			"Psychic · Flying \n" + 
			"#178\n" + 
			"Xatu\n" + 
			"Psychic · Flying \n" + 
			"#179\n" + 
			"Mareep\n" + 
			"Electric\n" + 
			"#180\n" + 
			"Flaaffy\n" + 
			"Electric \n" + 
			"#181\n" + 
			"Ampharos\n" + 
			"Electric \n" + 
			"#182\n" + 
			"Bellossom\n" + 
			"Grass \n" + 
			"#183\n" + 
			"Marill\n" + 
			"Water · Fairy \n" + 
			"#184\n" + 
			"Azumarill\n" + 
			"Water · Fairy \n" + 
			"#185\n" + 
			"Sudowoodo\n" + 
			"Rock \n" + 
			"#186\n" + 
			"Politoed\n" + 
			"Water\n" + 
			"#187\n" + 
			"Hoppip\n" + 
			"Grass · Flying \n" + 
			"#188\n" + 
			"Skiploom\n" + 
			"Grass · Flying \n" + 
			"#189\n" + 
			"Jumpluff\n" + 
			"Grass · Flying \n" + 
			"#190\n" + 
			"Aipom\n" + 
			"Normal \n" + 
			"#191\n" + 
			"Sunkern\n" + 
			"Grass \n" + 
			"#192\n" + 
			"Sunflora\n" + 
			"Grass \n" + 
			"#193\n" + 
			"Yanma\n" + 
			"Bug · Flying\n" + 
			"#194\n" + 
			"Wooper\n" + 
			"Water · Ground \n" + 
			"#195\n" + 
			"Quagsire\n" + 
			"Water · Ground \n" + 
			"#196\n" + 
			"Espeon\n" + 
			"Psychic \n" + 
			"#197\n" + 
			"Umbreon\n" + 
			"Dark \n" + 
			"#198\n" + 
			"Murkrow\n" + 
			"Dark · Flying \n" + 
			"#199\n" + 
			"Slowking\n" + 
			"Water · Psychic \n" + 
			"#200\n" + 
			"Misdreavus\n" + 
			"Ghost\n" + 
			"#201\n" + 
			"Unown\n" + 
			"Psychic \n" + 
			"#202\n" + 
			"Wobbuffet\n" + 
			"Psychic \n" + 
			"#203\n" + 
			"Girafarig\n" + 
			"Normal · Psychic \n" + 
			"#204\n" + 
			"Pineco\n" + 
			"Bug \n" + 
			"#205\n" + 
			"Forretress\n" + 
			"Bug · Steel \n" + 
			"#206\n" + 
			"Dunsparce\n" + 
			"Normal \n" + 
			"#207\n" + 
			"Gligar\n" + 
			"Ground · Flying\n" + 
			"#208\n" + 
			"Steelix\n" + 
			"Steel · Ground \n" + 
			"#209\n" + 
			"Snubbull\n" + 
			"Fairy \n" + 
			"#210\n" + 
			"Granbull\n" + 
			"Fairy \n" + 
			"#211\n" + 
			"Qwilfish\n" + 
			"Water · Poison \n" + 
			"#212\n" + 
			"Scizor\n" + 
			"Bug · Steel \n" + 
			"#213\n" + 
			"Shuckle\n" + 
			"Bug · Rock \n" + 
			"#214\n" + 
			"Heracross\n" + 
			"Bug · Fighting\n" + 
			"#215\n" + 
			"Sneasel\n" + 
			"Dark · Ice \n" + 
			"#216\n" + 
			"Teddiursa\n" + 
			"Normal \n" + 
			"#217\n" + 
			"Ursaring\n" + 
			"Normal \n" + 
			"#218\n" + 
			"Slugma\n" + 
			"Fire \n" + 
			"#219\n" + 
			"Magcargo\n" + 
			"Fire · Rock \n" + 
			"#220\n" + 
			"Swinub\n" + 
			"Ice · Ground \n" + 
			"#221\n" + 
			"Piloswine\n" + 
			"Ice · Ground\n" + 
			"#222\n" + 
			"Corsola\n" + 
			"Water · Rock \n" + 
			"#223\n" + 
			"Remoraid\n" + 
			"Water \n" + 
			"#224\n" + 
			"Octillery\n" + 
			"Water \n" + 
			"#225\n" + 
			"Delibird\n" + 
			"Ice · Flying \n" + 
			"#226\n" + 
			"Mantine\n" + 
			"Water · Flying \n" + 
			"#227\n" + 
			"Skarmory\n" + 
			"Steel · Flying \n" + 
			"#228\n" + 
			"Houndour\n" + 
			"Dark · Fire\n" + 
			"#229\n" + 
			"Houndoom\n" + 
			"Dark · Fire \n" + 
			"#230\n" + 
			"Kingdra\n" + 
			"Water · Dragon \n" + 
			"#231\n" + 
			"Phanpy\n" + 
			"Ground \n" + 
			"#232\n" + 
			"Donphan\n" + 
			"Ground \n" + 
			"#233\n" + 
			"Porygon2\n" + 
			"Normal \n" + 
			"#234\n" + 
			"Stantler\n" + 
			"Normal \n" + 
			"#235\n" + 
			"Smeargle\n" + 
			"Normal\n" + 
			"#236\n" + 
			"Tyrogue\n" + 
			"Fighting \n" + 
			"#237\n" + 
			"Hitmontop\n" + 
			"Fighting \n" + 
			"#238\n" + 
			"Smoochum\n" + 
			"Ice · Psychic \n" + 
			"#239\n" + 
			"Elekid\n" + 
			"Electric \n" + 
			"#240\n" + 
			"Magby\n" + 
			"Fire \n" + 
			"#241\n" + 
			"Miltank\n" + 
			"Normal \n" + 
			"#242\n" + 
			"Blissey\n" + 
			"Normal\n" + 
			"#243\n" + 
			"Raikou\n" + 
			"Electric \n" + 
			"#244\n" + 
			"Entei\n" + 
			"Fire \n" + 
			"#245\n" + 
			"Suicune\n" + 
			"Water \n" + 
			"#246\n" + 
			"Larvitar\n" + 
			"Rock · Ground \n" + 
			"#247\n" + 
			"Pupitar\n" + 
			"Rock · Ground \n" + 
			"#248\n" + 
			"Tyranitar\n" + 
			"Rock · Dark \n" + 
			"#249\n" + 
			"Lugia\n" + 
			"Psychic · Flying\n" + 
			"#250\n" + 
			"Ho-oh\n" + 
			"Fire · Flying \n" + 
			"#251\n" + 
			"Celebi\n" + 
			"Psychic · Grass\n" + 
			"Generation 3 Pokémon\n" + 
			"\n" + 
			"#252\n" + 
			"Treecko\n" + 
			"Grass \n" + 
			"#253\n" + 
			"Grovyle\n" + 
			"Grass \n" + 
			"#254\n" + 
			"Sceptile\n" + 
			"Grass \n" + 
			"#255\n" + 
			"Torchic\n" + 
			"Fire \n" + 
			"#256\n" + 
			"Combusken\n" + 
			"Fire · Fighting \n" + 
			"#257\n" + 
			"Blaziken\n" + 
			"Fire · Fighting \n" + 
			"#258\n" + 
			"Mudkip\n" + 
			"Water\n" + 
			"#259\n" + 
			"Marshtomp\n" + 
			"Water · Ground \n" + 
			"#260\n" + 
			"Swampert\n" + 
			"Water · Ground \n" + 
			"#261\n" + 
			"Poochyena\n" + 
			"Dark \n" + 
			"#262\n" + 
			"Mightyena\n" + 
			"Dark \n" + 
			"#263\n" + 
			"Zigzagoon\n" + 
			"Normal \n" + 
			"#264\n" + 
			"Linoone\n" + 
			"Normal \n" + 
			"#265\n" + 
			"Wurmple\n" + 
			"Bug\n" + 
			"#266\n" + 
			"Silcoon\n" + 
			"Bug \n" + 
			"#267\n" + 
			"Beautifly\n" + 
			"Bug · Flying \n" + 
			"#268\n" + 
			"Cascoon\n" + 
			"Bug \n" + 
			"#269\n" + 
			"Dustox\n" + 
			"Bug · Poison \n" + 
			"#270\n" + 
			"Lotad\n" + 
			"Water · Grass \n" + 
			"#271\n" + 
			"Lombre\n" + 
			"Water · Grass \n" + 
			"#272\n" + 
			"Ludicolo\n" + 
			"Water · Grass\n" + 
			"#273\n" + 
			"Seedot\n" + 
			"Grass \n" + 
			"#274\n" + 
			"Nuzleaf\n" + 
			"Grass · Dark \n" + 
			"#275\n" + 
			"Shiftry\n" + 
			"Grass · Dark \n" + 
			"#276\n" + 
			"Taillow\n" + 
			"Normal · Flying \n" + 
			"#277\n" + 
			"Swellow\n" + 
			"Normal · Flying \n" + 
			"#278\n" + 
			"Wingull\n" + 
			"Water · Flying \n" + 
			"#279\n" + 
			"Pelipper\n" + 
			"Water · Flying\n" + 
			"#280\n" + 
			"Ralts\n" + 
			"Psychic · Fairy \n" + 
			"#281\n" + 
			"Kirlia\n" + 
			"Psychic · Fairy \n" + 
			"#282\n" + 
			"Gardevoir\n" + 
			"Psychic · Fairy \n" + 
			"#283\n" + 
			"Surskit\n" + 
			"Bug · Water \n" + 
			"#284\n" + 
			"Masquerain\n" + 
			"Bug · Flying \n" + 
			"#285\n" + 
			"Shroomish\n" + 
			"Grass \n" + 
			"#286\n" + 
			"Breloom\n" + 
			"Grass · Fighting\n" + 
			"#287\n" + 
			"Slakoth\n" + 
			"Normal \n" + 
			"#288\n" + 
			"Vigoroth\n" + 
			"Normal \n" + 
			"#289\n" + 
			"Slaking\n" + 
			"Normal \n" + 
			"#290\n" + 
			"Nincada\n" + 
			"Bug · Ground \n" + 
			"#291\n" + 
			"Ninjask\n" + 
			"Bug · Flying \n" + 
			"#292\n" + 
			"Shedinja\n" + 
			"Bug · Ghost \n" + 
			"#293\n" + 
			"Whismur\n" + 
			"Normal\n" + 
			"#294\n" + 
			"Loudred\n" + 
			"Normal \n" + 
			"#295\n" + 
			"Exploud\n" + 
			"Normal \n" + 
			"#296\n" + 
			"Makuhita\n" + 
			"Fighting \n" + 
			"#297\n" + 
			"Hariyama\n" + 
			"Fighting \n" + 
			"#298\n" + 
			"Azurill\n" + 
			"Normal · Fairy \n" + 
			"#299\n" + 
			"Nosepass\n" + 
			"Rock \n" + 
			"#300\n" + 
			"Skitty\n" + 
			"Normal\n" + 
			"#301\n" + 
			"Delcatty\n" + 
			"Normal \n" + 
			"#302\n" + 
			"Sableye\n" + 
			"Dark · Ghost \n" + 
			"#303\n" + 
			"Mawile\n" + 
			"Steel · Fairy \n" + 
			"#304\n" + 
			"Aron\n" + 
			"Steel · Rock \n" + 
			"#305\n" + 
			"Lairon\n" + 
			"Steel · Rock \n" + 
			"#306\n" + 
			"Aggron\n" + 
			"Steel · Rock \n" + 
			"#307\n" + 
			"Meditite\n" + 
			"Fighting · Psychic\n" + 
			"#308\n" + 
			"Medicham\n" + 
			"Fighting · Psychic \n" + 
			"#309\n" + 
			"Electrike\n" + 
			"Electric \n" + 
			"#310\n" + 
			"Manectric\n" + 
			"Electric \n" + 
			"#311\n" + 
			"Plusle\n" + 
			"Electric \n" + 
			"#312\n" + 
			"Minun\n" + 
			"Electric \n" + 
			"#313\n" + 
			"Volbeat\n" + 
			"Bug \n" + 
			"#314\n" + 
			"Illumise\n" + 
			"Bug\n" + 
			"#315\n" + 
			"Roselia\n" + 
			"Grass · Poison \n" + 
			"#316\n" + 
			"Gulpin\n" + 
			"Poison \n" + 
			"#317\n" + 
			"Swalot\n" + 
			"Poison \n" + 
			"#318\n" + 
			"Carvanha\n" + 
			"Water · Dark \n" + 
			"#319\n" + 
			"Sharpedo\n" + 
			"Water · Dark \n" + 
			"#320\n" + 
			"Wailmer\n" + 
			"Water \n" + 
			"#321\n" + 
			"Wailord\n" + 
			"Water\n" + 
			"#322\n" + 
			"Numel\n" + 
			"Fire · Ground \n" + 
			"#323\n" + 
			"Camerupt\n" + 
			"Fire · Ground \n" + 
			"#324\n" + 
			"Torkoal\n" + 
			"Fire \n" + 
			"#325\n" + 
			"Spoink\n" + 
			"Psychic \n" + 
			"#326\n" + 
			"Grumpig\n" + 
			"Psychic \n" + 
			"#327\n" + 
			"Spinda\n" + 
			"Normal \n" + 
			"#328\n" + 
			"Trapinch\n" + 
			"Ground\n" + 
			"#329\n" + 
			"Vibrava\n" + 
			"Ground · Dragon \n" + 
			"#330\n" + 
			"Flygon\n" + 
			"Ground · Dragon \n" + 
			"#331\n" + 
			"Cacnea\n" + 
			"Grass \n" + 
			"#332\n" + 
			"Cacturne\n" + 
			"Grass · Dark \n" + 
			"#333\n" + 
			"Swablu\n" + 
			"Normal · Flying \n" + 
			"#334\n" + 
			"Altaria\n" + 
			"Dragon · Flying \n" + 
			"#335\n" + 
			"Zangoose\n" + 
			"Normal\n" + 
			"#336\n" + 
			"Seviper\n" + 
			"Poison \n" + 
			"#337\n" + 
			"Lunatone\n" + 
			"Rock · Psychic \n" + 
			"#338\n" + 
			"Solrock\n" + 
			"Rock · Psychic \n" + 
			"#339\n" + 
			"Barboach\n" + 
			"Water · Ground \n" + 
			"#340\n" + 
			"Whiscash\n" + 
			"Water · Ground \n" + 
			"#341\n" + 
			"Corphish\n" + 
			"Water \n" + 
			"#342\n" + 
			"Crawdaunt\n" + 
			"Water · Dark\n" + 
			"#343\n" + 
			"Baltoy\n" + 
			"Ground · Psychic \n" + 
			"#344\n" + 
			"Claydol\n" + 
			"Ground · Psychic \n" + 
			"#345\n" + 
			"Lileep\n" + 
			"Rock · Grass \n" + 
			"#346\n" + 
			"Cradily\n" + 
			"Rock · Grass \n" + 
			"#347\n" + 
			"Anorith\n" + 
			"Rock · Bug \n" + 
			"#348\n" + 
			"Armaldo\n" + 
			"Rock · Bug \n" + 
			"#349\n" + 
			"Feebas\n" + 
			"Water\n" + 
			"#350\n" + 
			"Milotic\n" + 
			"Water \n" + 
			"#351\n" + 
			"Castform\n" + 
			"Normal \n" + 
			"#352\n" + 
			"Kecleon\n" + 
			"Normal \n" + 
			"#353\n" + 
			"Shuppet\n" + 
			"Ghost \n" + 
			"#354\n" + 
			"Banette\n" + 
			"Ghost \n" + 
			"#355\n" + 
			"Duskull\n" + 
			"Ghost \n" + 
			"#356\n" + 
			"Dusclops\n" + 
			"Ghost\n" + 
			"#357\n" + 
			"Tropius\n" + 
			"Grass · Flying \n" + 
			"#358\n" + 
			"Chimecho\n" + 
			"Psychic \n" + 
			"#359\n" + 
			"Absol\n" + 
			"Dark \n" + 
			"#360\n" + 
			"Wynaut\n" + 
			"Psychic \n" + 
			"#361\n" + 
			"Snorunt\n" + 
			"Ice \n" + 
			"#362\n" + 
			"Glalie\n" + 
			"Ice \n" + 
			"#363\n" + 
			"Spheal\n" + 
			"Ice · Water\n" + 
			"#364\n" + 
			"Sealeo\n" + 
			"Ice · Water \n" + 
			"#365\n" + 
			"Walrein\n" + 
			"Ice · Water \n" + 
			"#366\n" + 
			"Clamperl\n" + 
			"Water \n" + 
			"#367\n" + 
			"Huntail\n" + 
			"Water \n" + 
			"#368\n" + 
			"Gorebyss\n" + 
			"Water \n" + 
			"#369\n" + 
			"Relicanth\n" + 
			"Water · Rock \n" + 
			"#370\n" + 
			"Luvdisc\n" + 
			"Water\n" + 
			"#371\n" + 
			"Bagon\n" + 
			"Dragon \n" + 
			"#372\n" + 
			"Shelgon\n" + 
			"Dragon \n" + 
			"#373\n" + 
			"Salamence\n" + 
			"Dragon · Flying \n" + 
			"#374\n" + 
			"Beldum\n" + 
			"Steel · Psychic \n" + 
			"#375\n" + 
			"Metang\n" + 
			"Steel · Psychic \n" + 
			"#376\n" + 
			"Metagross\n" + 
			"Steel · Psychic \n" + 
			"#377\n" + 
			"Regirock\n" + 
			"Rock\n" + 
			"#378\n" + 
			"Regice\n" + 
			"Ice \n" + 
			"#379\n" + 
			"Registeel\n" + 
			"Steel \n" + 
			"#380\n" + 
			"Latias\n" + 
			"Dragon · Psychic \n" + 
			"#381\n" + 
			"Latios\n" + 
			"Dragon · Psychic \n" + 
			"#382\n" + 
			"Kyogre\n" + 
			"Water \n" + 
			"#383\n" + 
			"Groudon\n" + 
			"Ground \n" + 
			"#384\n" + 
			"Rayquaza\n" + 
			"Dragon · Flying\n" + 
			"#385\n" + 
			"Jirachi\n" + 
			"Steel · Psychic \n" + 
			"#386\n" + 
			"Deoxys\n" + 
			"Psychic\n" + 
			"Generation 4 Pokémon\n" + 
			"\n" + 
			"#387\n" + 
			"Turtwig\n" + 
			"Grass \n" + 
			"#388\n" + 
			"Grotle\n" + 
			"Grass \n" + 
			"#389\n" + 
			"Torterra\n" + 
			"Grass · Ground \n" + 
			"#390\n" + 
			"Chimchar\n" + 
			"Fire \n" + 
			"#391\n" + 
			"Monferno\n" + 
			"Fire · Fighting \n" + 
			"#392\n" + 
			"Infernape\n" + 
			"Fire · Fighting \n" + 
			"#393\n" + 
			"Piplup\n" + 
			"Water\n" + 
			"#394\n" + 
			"Prinplup\n" + 
			"Water \n" + 
			"#395\n" + 
			"Empoleon\n" + 
			"Water · Steel \n" + 
			"#396\n" + 
			"Starly\n" + 
			"Normal · Flying \n" + 
			"#397\n" + 
			"Staravia\n" + 
			"Normal · Flying \n" + 
			"#398\n" + 
			"Staraptor\n" + 
			"Normal · Flying \n" + 
			"#399\n" + 
			"Bidoof\n" + 
			"Normal \n" + 
			"#400\n" + 
			"Bibarel\n" + 
			"Normal · Water\n" + 
			"#401\n" + 
			"Kricketot\n" + 
			"Bug \n" + 
			"#402\n" + 
			"Kricketune\n" + 
			"Bug \n" + 
			"#403\n" + 
			"Shinx\n" + 
			"Electric \n" + 
			"#404\n" + 
			"Luxio\n" + 
			"Electric \n" + 
			"#405\n" + 
			"Luxray\n" + 
			"Electric \n" + 
			"#406\n" + 
			"Budew\n" + 
			"Grass · Poison \n" + 
			"#407\n" + 
			"Roserade\n" + 
			"Grass · Poison\n" + 
			"#408\n" + 
			"Cranidos\n" + 
			"Rock \n" + 
			"#409\n" + 
			"Rampardos\n" + 
			"Rock \n" + 
			"#410\n" + 
			"Shieldon\n" + 
			"Rock · Steel \n" + 
			"#411\n" + 
			"Bastiodon\n" + 
			"Rock · Steel \n" + 
			"#412\n" + 
			"Burmy\n" + 
			"Bug \n" + 
			"#413\n" + 
			"Wormadam\n" + 
			"Bug · Grass \n" + 
			"#414\n" + 
			"Mothim\n" + 
			"Bug · Flying\n" + 
			"#415\n" + 
			"Combee\n" + 
			"Bug · Flying \n" + 
			"#416\n" + 
			"Vespiquen\n" + 
			"Bug · Flying \n" + 
			"#417\n" + 
			"Pachirisu\n" + 
			"Electric \n" + 
			"#418\n" + 
			"Buizel\n" + 
			"Water \n" + 
			"#419\n" + 
			"Floatzel\n" + 
			"Water \n" + 
			"#420\n" + 
			"Cherubi\n" + 
			"Grass \n" + 
			"#421\n" + 
			"Cherrim\n" + 
			"Grass\n" + 
			"#422\n" + 
			"Shellos\n" + 
			"Water \n" + 
			"#423\n" + 
			"Gastrodon\n" + 
			"Water · Ground \n" + 
			"#424\n" + 
			"Ambipom\n" + 
			"Normal \n" + 
			"#425\n" + 
			"Drifloon\n" + 
			"Ghost · Flying \n" + 
			"#426\n" + 
			"Drifblim\n" + 
			"Ghost · Flying \n" + 
			"#427\n" + 
			"Buneary\n" + 
			"Normal \n" + 
			"#428\n" + 
			"Lopunny\n" + 
			"Normal\n" + 
			"#429\n" + 
			"Mismagius\n" + 
			"Ghost \n" + 
			"#430\n" + 
			"Honchkrow\n" + 
			"Dark · Flying \n" + 
			"#431\n" + 
			"Glameow\n" + 
			"Normal \n" + 
			"#432\n" + 
			"Purugly\n" + 
			"Normal \n" + 
			"#433\n" + 
			"Chingling\n" + 
			"Psychic \n" + 
			"#434\n" + 
			"Stunky\n" + 
			"Poison · Dark \n" + 
			"#435\n" + 
			"Skuntank\n" + 
			"Poison · Dark\n" + 
			"#436\n" + 
			"Bronzor\n" + 
			"Steel · Psychic \n" + 
			"#437\n" + 
			"Bronzong\n" + 
			"Steel · Psychic \n" + 
			"#438\n" + 
			"Bonsly\n" + 
			"Rock \n" + 
			"#439\n" + 
			"Mime Jr.\n" + 
			"Psychic · Fairy \n" + 
			"#440\n" + 
			"Happiny\n" + 
			"Normal \n" + 
			"#441\n" + 
			"Chatot\n" + 
			"Normal · Flying \n" + 
			"#442\n" + 
			"Spiritomb\n" + 
			"Ghost · Dark\n" + 
			"#443\n" + 
			"Gible\n" + 
			"Dragon · Ground \n" + 
			"#444\n" + 
			"Gabite\n" + 
			"Dragon · Ground \n" + 
			"#445\n" + 
			"Garchomp\n" + 
			"Dragon · Ground \n" + 
			"#446\n" + 
			"Munchlax\n" + 
			"Normal \n" + 
			"#447\n" + 
			"Riolu\n" + 
			"Fighting \n" + 
			"#448\n" + 
			"Lucario\n" + 
			"Fighting · Steel \n" + 
			"#449\n" + 
			"Hippopotas\n" + 
			"Ground\n" + 
			"#450\n" + 
			"Hippowdon\n" + 
			"Ground \n" + 
			"#451\n" + 
			"Skorupi\n" + 
			"Poison · Bug \n" + 
			"#452\n" + 
			"Drapion\n" + 
			"Poison · Dark \n" + 
			"#453\n" + 
			"Croagunk\n" + 
			"Poison · Fighting \n" + 
			"#454\n" + 
			"Toxicroak\n" + 
			"Poison · Fighting \n" + 
			"#455\n" + 
			"Carnivine\n" + 
			"Grass \n" + 
			"#456\n" + 
			"Finneon\n" + 
			"Water\n" + 
			"#457\n" + 
			"Lumineon\n" + 
			"Water \n" + 
			"#458\n" + 
			"Mantyke\n" + 
			"Water · Flying \n" + 
			"#459\n" + 
			"Snover\n" + 
			"Grass · Ice \n" + 
			"#460\n" + 
			"Abomasnow\n" + 
			"Grass · Ice \n" + 
			"#461\n" + 
			"Weavile\n" + 
			"Dark · Ice \n" + 
			"#462\n" + 
			"Magnezone\n" + 
			"Electric · Steel \n" + 
			"#463\n" + 
			"Lickilicky\n" + 
			"Normal\n" + 
			"#464\n" + 
			"Rhyperior\n" + 
			"Ground · Rock \n" + 
			"#465\n" + 
			"Tangrowth\n" + 
			"Grass \n" + 
			"#466\n" + 
			"Electivire\n" + 
			"Electric \n" + 
			"#467\n" + 
			"Magmortar\n" + 
			"Fire \n" + 
			"#468\n" + 
			"Togekiss\n" + 
			"Fairy · Flying \n" + 
			"#469\n" + 
			"Yanmega\n" + 
			"Bug · Flying \n" + 
			"#470\n" + 
			"Leafeon\n" + 
			"Grass\n" + 
			"#471\n" + 
			"Glaceon\n" + 
			"Ice \n" + 
			"#472\n" + 
			"Gliscor\n" + 
			"Ground · Flying \n" + 
			"#473\n" + 
			"Mamoswine\n" + 
			"Ice · Ground \n" + 
			"#474\n" + 
			"Porygon-Z\n" + 
			"Normal \n" + 
			"#475\n" + 
			"Gallade\n" + 
			"Psychic · Fighting \n" + 
			"#476\n" + 
			"Probopass\n" + 
			"Rock · Steel \n" + 
			"#477\n" + 
			"Dusknoir\n" + 
			"Ghost\n" + 
			"#478\n" + 
			"Froslass\n" + 
			"Ice · Ghost \n" + 
			"#479\n" + 
			"Rotom\n" + 
			"Electric · Ghost \n" + 
			"#480\n" + 
			"Uxie\n" + 
			"Psychic \n" + 
			"#481\n" + 
			"Mesprit\n" + 
			"Psychic \n" + 
			"#482\n" + 
			"Azelf\n" + 
			"Psychic \n" + 
			"#483\n" + 
			"Dialga\n" + 
			"Steel · Dragon \n" + 
			"#484\n" + 
			"Palkia\n" + 
			"Water · Dragon\n" + 
			"#485\n" + 
			"Heatran\n" + 
			"Fire · Steel \n" + 
			"#486\n" + 
			"Regigigas\n" + 
			"Normal \n" + 
			"#487\n" + 
			"Giratina\n" + 
			"Ghost · Dragon \n" + 
			"#488\n" + 
			"Cresselia\n" + 
			"Psychic \n" + 
			"#489\n" + 
			"Phione\n" + 
			"Water \n" + 
			"#490\n" + 
			"Manaphy\n" + 
			"Water \n" + 
			"#491\n" + 
			"Darkrai\n" + 
			"Dark\n" + 
			"#492\n" + 
			"Shaymin\n" + 
			"Grass \n" + 
			"#493\n" + 
			"Arceus\n" + 
			"Normal\n" + 
			"Generation 5 Pokémon\n" + 
			"\n" + 
			"#494\n" + 
			"Victini\n" + 
			"Psychic · Fire \n" + 
			"#495\n" + 
			"Snivy\n" + 
			"Grass \n" + 
			"#496\n" + 
			"Servine\n" + 
			"Grass \n" + 
			"#497\n" + 
			"Serperior\n" + 
			"Grass \n" + 
			"#498\n" + 
			"Tepig\n" + 
			"Fire \n" + 
			"#499\n" + 
			"Pignite\n" + 
			"Fire · Fighting \n" + 
			"#500\n" + 
			"Emboar\n" + 
			"Fire · Fighting\n" + 
			"#501\n" + 
			"Oshawott\n" + 
			"Water \n" + 
			"#502\n" + 
			"Dewott\n" + 
			"Water \n" + 
			"#503\n" + 
			"Samurott\n" + 
			"Water \n" + 
			"#504\n" + 
			"Patrat\n" + 
			"Normal \n" + 
			"#505\n" + 
			"Watchog\n" + 
			"Normal \n" + 
			"#506\n" + 
			"Lillipup\n" + 
			"Normal \n" + 
			"#507\n" + 
			"Herdier\n" + 
			"Normal\n" + 
			"#508\n" + 
			"Stoutland\n" + 
			"Normal \n" + 
			"#509\n" + 
			"Purrloin\n" + 
			"Dark \n" + 
			"#510\n" + 
			"Liepard\n" + 
			"Dark \n" + 
			"#511\n" + 
			"Pansage\n" + 
			"Grass \n" + 
			"#512\n" + 
			"Simisage\n" + 
			"Grass \n" + 
			"#513\n" + 
			"Pansear\n" + 
			"Fire \n" + 
			"#514\n" + 
			"Simisear\n" + 
			"Fire\n" + 
			"#515\n" + 
			"Panpour\n" + 
			"Water \n" + 
			"#516\n" + 
			"Simipour\n" + 
			"Water \n" + 
			"#517\n" + 
			"Munna\n" + 
			"Psychic \n" + 
			"#518\n" + 
			"Musharna\n" + 
			"Psychic \n" + 
			"#519\n" + 
			"Pidove\n" + 
			"Normal · Flying \n" + 
			"#520\n" + 
			"Tranquill\n" + 
			"Normal · Flying \n" + 
			"#521\n" + 
			"Unfezant\n" + 
			"Normal · Flying\n" + 
			"#522\n" + 
			"Blitzle\n" + 
			"Electric \n" + 
			"#523\n" + 
			"Zebstrika\n" + 
			"Electric \n" + 
			"#524\n" + 
			"Roggenrola\n" + 
			"Rock \n" + 
			"#525\n" + 
			"Boldore\n" + 
			"Rock \n" + 
			"#526\n" + 
			"Gigalith\n" + 
			"Rock \n" + 
			"#527\n" + 
			"Woobat\n" + 
			"Psychic · Flying \n" + 
			"#528\n" + 
			"Swoobat\n" + 
			"Psychic · Flying\n" + 
			"#529\n" + 
			"Drilbur\n" + 
			"Ground \n" + 
			"#530\n" + 
			"Excadrill\n" + 
			"Ground · Steel \n" + 
			"#531\n" + 
			"Audino\n" + 
			"Normal \n" + 
			"#532\n" + 
			"Timburr\n" + 
			"Fighting \n" + 
			"#533\n" + 
			"Gurdurr\n" + 
			"Fighting \n" + 
			"#534\n" + 
			"Conkeldurr\n" + 
			"Fighting \n" + 
			"#535\n" + 
			"Tympole\n" + 
			"Water\n" + 
			"#536\n" + 
			"Palpitoad\n" + 
			"Water · Ground \n" + 
			"#537\n" + 
			"Seismitoad\n" + 
			"Water · Ground \n" + 
			"#538\n" + 
			"Throh\n" + 
			"Fighting \n" + 
			"#539\n" + 
			"Sawk\n" + 
			"Fighting \n" + 
			"#540\n" + 
			"Sewaddle\n" + 
			"Bug · Grass \n" + 
			"#541\n" + 
			"Swadloon\n" + 
			"Bug · Grass \n" + 
			"#542\n" + 
			"Leavanny\n" + 
			"Bug · Grass\n" + 
			"#543\n" + 
			"Venipede\n" + 
			"Bug · Poison \n" + 
			"#544\n" + 
			"Whirlipede\n" + 
			"Bug · Poison \n" + 
			"#545\n" + 
			"Scolipede\n" + 
			"Bug · Poison \n" + 
			"#546\n" + 
			"Cottonee\n" + 
			"Grass · Fairy \n" + 
			"#547\n" + 
			"Whimsicott\n" + 
			"Grass · Fairy \n" + 
			"#548\n" + 
			"Petilil\n" + 
			"Grass \n" + 
			"#549\n" + 
			"Lilligant\n" + 
			"Grass\n" + 
			"#550\n" + 
			"Basculin\n" + 
			"Water \n" + 
			"#551\n" + 
			"Sandile\n" + 
			"Ground · Dark \n" + 
			"#552\n" + 
			"Krokorok\n" + 
			"Ground · Dark \n" + 
			"#553\n" + 
			"Krookodile\n" + 
			"Ground · Dark \n" + 
			"#554\n" + 
			"Darumaka\n" + 
			"Fire \n" + 
			"#555\n" + 
			"Darmanitan\n" + 
			"Fire \n" + 
			"#556\n" + 
			"Maractus\n" + 
			"Grass\n" + 
			"#557\n" + 
			"Dwebble\n" + 
			"Bug · Rock \n" + 
			"#558\n" + 
			"Crustle\n" + 
			"Bug · Rock \n" + 
			"#559\n" + 
			"Scraggy\n" + 
			"Dark · Fighting \n" + 
			"#560\n" + 
			"Scrafty\n" + 
			"Dark · Fighting \n" + 
			"#561\n" + 
			"Sigilyph\n" + 
			"Psychic · Flying \n" + 
			"#562\n" + 
			"Yamask\n" + 
			"Ghost \n" + 
			"#563\n" + 
			"Cofagrigus\n" + 
			"Ghost\n" + 
			"#564\n" + 
			"Tirtouga\n" + 
			"Water · Rock \n" + 
			"#565\n" + 
			"Carracosta\n" + 
			"Water · Rock \n" + 
			"#566\n" + 
			"Archen\n" + 
			"Rock · Flying \n" + 
			"#567\n" + 
			"Archeops\n" + 
			"Rock · Flying \n" + 
			"#568\n" + 
			"Trubbish\n" + 
			"Poison \n" + 
			"#569\n" + 
			"Garbodor\n" + 
			"Poison \n" + 
			"#570\n" + 
			"Zorua\n" + 
			"Dark\n" + 
			"#571\n" + 
			"Zoroark\n" + 
			"Dark \n" + 
			"#572\n" + 
			"Minccino\n" + 
			"Normal \n" + 
			"#573\n" + 
			"Cinccino\n" + 
			"Normal \n" + 
			"#574\n" + 
			"Gothita\n" + 
			"Psychic \n" + 
			"#575\n" + 
			"Gothorita\n" + 
			"Psychic \n" + 
			"#576\n" + 
			"Gothitelle\n" + 
			"Psychic \n" + 
			"#577\n" + 
			"Solosis\n" + 
			"Psychic\n" + 
			"#578\n" + 
			"Duosion\n" + 
			"Psychic \n" + 
			"#579\n" + 
			"Reuniclus\n" + 
			"Psychic \n" + 
			"#580\n" + 
			"Ducklett\n" + 
			"Water · Flying \n" + 
			"#581\n" + 
			"Swanna\n" + 
			"Water · Flying \n" + 
			"#582\n" + 
			"Vanillite\n" + 
			"Ice \n" + 
			"#583\n" + 
			"Vanillish\n" + 
			"Ice \n" + 
			"#584\n" + 
			"Vanilluxe\n" + 
			"Ice\n" + 
			"#585\n" + 
			"Deerling\n" + 
			"Normal · Grass \n" + 
			"#586\n" + 
			"Sawsbuck\n" + 
			"Normal · Grass \n" + 
			"#587\n" + 
			"Emolga\n" + 
			"Electric · Flying \n" + 
			"#588\n" + 
			"Karrablast\n" + 
			"Bug \n" + 
			"#589\n" + 
			"Escavalier\n" + 
			"Bug · Steel \n" + 
			"#590\n" + 
			"Foongus\n" + 
			"Grass · Poison \n" + 
			"#591\n" + 
			"Amoonguss\n" + 
			"Grass · Poison\n" + 
			"#592\n" + 
			"Frillish\n" + 
			"Water · Ghost \n" + 
			"#593\n" + 
			"Jellicent\n" + 
			"Water · Ghost \n" + 
			"#594\n" + 
			"Alomomola\n" + 
			"Water \n" + 
			"#595\n" + 
			"Joltik\n" + 
			"Bug · Electric \n" + 
			"#596\n" + 
			"Galvantula\n" + 
			"Bug · Electric \n" + 
			"#597\n" + 
			"Ferroseed\n" + 
			"Grass · Steel \n" + 
			"#598\n" + 
			"Ferrothorn\n" + 
			"Grass · Steel\n" + 
			"#599\n" + 
			"Klink\n" + 
			"Steel \n" + 
			"#600\n" + 
			"Klang\n" + 
			"Steel \n" + 
			"#601\n" + 
			"Klinklang\n" + 
			"Steel \n" + 
			"#602\n" + 
			"Tynamo\n" + 
			"Electric \n" + 
			"#603\n" + 
			"Eelektrik\n" + 
			"Electric \n" + 
			"#604\n" + 
			"Eelektross\n" + 
			"Electric \n" + 
			"#605\n" + 
			"Elgyem\n" + 
			"Psychic\n" + 
			"#606\n" + 
			"Beheeyem\n" + 
			"Psychic \n" + 
			"#607\n" + 
			"Litwick\n" + 
			"Ghost · Fire \n" + 
			"#608\n" + 
			"Lampent\n" + 
			"Ghost · Fire \n" + 
			"#609\n" + 
			"Chandelure\n" + 
			"Ghost · Fire \n" + 
			"#610\n" + 
			"Axew\n" + 
			"Dragon \n" + 
			"#611\n" + 
			"Fraxure\n" + 
			"Dragon \n" + 
			"#612\n" + 
			"Haxorus\n" + 
			"Dragon\n" + 
			"#613\n" + 
			"Cubchoo\n" + 
			"Ice \n" + 
			"#614\n" + 
			"Beartic\n" + 
			"Ice \n" + 
			"#615\n" + 
			"Cryogonal\n" + 
			"Ice \n" + 
			"#616\n" + 
			"Shelmet\n" + 
			"Bug \n" + 
			"#617\n" + 
			"Accelgor\n" + 
			"Bug \n" + 
			"#618\n" + 
			"Stunfisk\n" + 
			"Electric · Ground \n" + 
			"#619\n" + 
			"Mienfoo\n" + 
			"Fighting\n" + 
			"#620\n" + 
			"Mienshao\n" + 
			"Fighting \n" + 
			"#621\n" + 
			"Druddigon\n" + 
			"Dragon \n" + 
			"#622\n" + 
			"Golett\n" + 
			"Ground · Ghost \n" + 
			"#623\n" + 
			"Golurk\n" + 
			"Ground · Ghost \n" + 
			"#624\n" + 
			"Pawniard\n" + 
			"Dark · Steel \n" + 
			"#625\n" + 
			"Bisharp\n" + 
			"Dark · Steel \n" + 
			"#626\n" + 
			"Bouffalant\n" + 
			"Normal\n" + 
			"#627\n" + 
			"Rufflet\n" + 
			"Normal · Flying \n" + 
			"#628\n" + 
			"Braviary\n" + 
			"Normal · Flying \n" + 
			"#629\n" + 
			"Vullaby\n" + 
			"Dark · Flying \n" + 
			"#630\n" + 
			"Mandibuzz\n" + 
			"Dark · Flying \n" + 
			"#631\n" + 
			"Heatmor\n" + 
			"Fire \n" + 
			"#632\n" + 
			"Durant\n" + 
			"Bug · Steel \n" + 
			"#633\n" + 
			"Deino\n" + 
			"Dark · Dragon\n" + 
			"#634\n" + 
			"Zweilous\n" + 
			"Dark · Dragon \n" + 
			"#635\n" + 
			"Hydreigon\n" + 
			"Dark · Dragon \n" + 
			"#636\n" + 
			"Larvesta\n" + 
			"Bug · Fire \n" + 
			"#637\n" + 
			"Volcarona\n" + 
			"Bug · Fire \n" + 
			"#638\n" + 
			"Cobalion\n" + 
			"Steel · Fighting \n" + 
			"#639\n" + 
			"Terrakion\n" + 
			"Rock · Fighting \n" + 
			"#640\n" + 
			"Virizion\n" + 
			"Grass · Fighting\n" + 
			"#641\n" + 
			"Tornadus\n" + 
			"Flying \n" + 
			"#642\n" + 
			"Thundurus\n" + 
			"Electric · Flying \n" + 
			"#643\n" + 
			"Reshiram\n" + 
			"Dragon · Fire \n" + 
			"#644\n" + 
			"Zekrom\n" + 
			"Dragon · Electric \n" + 
			"#645\n" + 
			"Landorus\n" + 
			"Ground · Flying \n" + 
			"#646\n" + 
			"Kyurem\n" + 
			"Dragon · Ice \n" + 
			"#647\n" + 
			"Keldeo\n" + 
			"Water · Fighting\n" + 
			"#648\n" + 
			"Meloetta\n" + 
			"Normal · Psychic \n" + 
			"#649\n" + 
			"Genesect\n" + 
			"Bug · Steel\n" + 
			"Generation 6 Pokémon\n" + 
			"\n" + 
			"#650\n" + 
			"Chespin\n" + 
			"Grass \n" + 
			"#651\n" + 
			"Quilladin\n" + 
			"Grass \n" + 
			"#652\n" + 
			"Chesnaught\n" + 
			"Grass · Fighting \n" + 
			"#653\n" + 
			"Fennekin\n" + 
			"Fire \n" + 
			"#654\n" + 
			"Braixen\n" + 
			"Fire \n" + 
			"#655\n" + 
			"Delphox\n" + 
			"Fire · Psychic \n" + 
			"#656\n" + 
			"Froakie\n" + 
			"Water\n" + 
			"#657\n" + 
			"Frogadier\n" + 
			"Water \n" + 
			"#658\n" + 
			"Greninja\n" + 
			"Water · Dark \n" + 
			"#659\n" + 
			"Bunnelby\n" + 
			"Normal \n" + 
			"#660\n" + 
			"Diggersby\n" + 
			"Normal · Ground \n" + 
			"#661\n" + 
			"Fletchling\n" + 
			"Normal · Flying \n" + 
			"#662\n" + 
			"Fletchinder\n" + 
			"Fire · Flying \n" + 
			"#663\n" + 
			"Talonflame\n" + 
			"Fire · Flying\n" + 
			"#664\n" + 
			"Scatterbug\n" + 
			"Bug \n" + 
			"#665\n" + 
			"Spewpa\n" + 
			"Bug \n" + 
			"#666\n" + 
			"Vivillon\n" + 
			"Bug · Flying \n" + 
			"#667\n" + 
			"Litleo\n" + 
			"Fire · Normal \n" + 
			"#668\n" + 
			"Pyroar\n" + 
			"Fire · Normal \n" + 
			"#669\n" + 
			"Flabébé\n" + 
			"Fairy \n" + 
			"#670\n" + 
			"Floette\n" + 
			"Fairy\n" + 
			"#671\n" + 
			"Florges\n" + 
			"Fairy \n" + 
			"#672\n" + 
			"Skiddo\n" + 
			"Grass \n" + 
			"#673\n" + 
			"Gogoat\n" + 
			"Grass \n" + 
			"#674\n" + 
			"Pancham\n" + 
			"Fighting \n" + 
			"#675\n" + 
			"Pangoro\n" + 
			"Fighting · Dark \n" + 
			"#676\n" + 
			"Furfrou\n" + 
			"Normal \n" + 
			"#677\n" + 
			"Espurr\n" + 
			"Psychic\n" + 
			"#678\n" + 
			"Meowstic\n" + 
			"Psychic \n" + 
			"#679\n" + 
			"Honedge\n" + 
			"Steel · Ghost \n" + 
			"#680\n" + 
			"Doublade\n" + 
			"Steel · Ghost \n" + 
			"#681\n" + 
			"Aegislash\n" + 
			"Steel · Ghost \n" + 
			"#682\n" + 
			"Spritzee\n" + 
			"Fairy \n" + 
			"#683\n" + 
			"Aromatisse\n" + 
			"Fairy \n" + 
			"#684\n" + 
			"Swirlix\n" + 
			"Fairy\n" + 
			"#685\n" + 
			"Slurpuff\n" + 
			"Fairy \n" + 
			"#686\n" + 
			"Inkay\n" + 
			"Dark · Psychic \n" + 
			"#687\n" + 
			"Malamar\n" + 
			"Dark · Psychic \n" + 
			"#688\n" + 
			"Binacle\n" + 
			"Rock · Water \n" + 
			"#689\n" + 
			"Barbaracle\n" + 
			"Rock · Water \n" + 
			"#690\n" + 
			"Skrelp\n" + 
			"Poison · Water \n" + 
			"#691\n" + 
			"Dragalge\n" + 
			"Poison · Dragon\n" + 
			"#692\n" + 
			"Clauncher\n" + 
			"Water \n" + 
			"#693\n" + 
			"Clawitzer\n" + 
			"Water \n" + 
			"#694\n" + 
			"Helioptile\n" + 
			"Electric · Normal \n" + 
			"#695\n" + 
			"Heliolisk\n" + 
			"Electric · Normal \n" + 
			"#696\n" + 
			"Tyrunt\n" + 
			"Rock · Dragon \n" + 
			"#697\n" + 
			"Tyrantrum\n" + 
			"Rock · Dragon \n" + 
			"#698\n" + 
			"Amaura\n" + 
			"Rock · Ice\n" + 
			"#699\n" + 
			"Aurorus\n" + 
			"Rock · Ice \n" + 
			"#700\n" + 
			"Sylveon\n" + 
			"Fairy \n" + 
			"#701\n" + 
			"Hawlucha\n" + 
			"Fighting · Flying \n" + 
			"#702\n" + 
			"Dedenne\n" + 
			"Electric · Fairy \n" + 
			"#703\n" + 
			"Carbink\n" + 
			"Rock · Fairy \n" + 
			"#704\n" + 
			"Goomy\n" + 
			"Dragon \n" + 
			"#705\n" + 
			"Sliggoo\n" + 
			"Dragon\n" + 
			"#706\n" + 
			"Goodra\n" + 
			"Dragon \n" + 
			"#707\n" + 
			"Klefki\n" + 
			"Steel · Fairy \n" + 
			"#708\n" + 
			"Phantump\n" + 
			"Ghost · Grass \n" + 
			"#709\n" + 
			"Trevenant\n" + 
			"Ghost · Grass \n" + 
			"#710\n" + 
			"Pumpkaboo\n" + 
			"Ghost · Grass \n" + 
			"#711\n" + 
			"Gourgeist\n" + 
			"Ghost · Grass \n" + 
			"#712\n" + 
			"Bergmite\n" + 
			"Ice\n" + 
			"#713\n" + 
			"Avalugg\n" + 
			"Ice \n" + 
			"#714\n" + 
			"Noibat\n" + 
			"Flying · Dragon \n" + 
			"#715\n" + 
			"Noivern\n" + 
			"Flying · Dragon \n" + 
			"#716\n" + 
			"Xerneas\n" + 
			"Fairy \n" + 
			"#717\n" + 
			"Yveltal\n" + 
			"Dark · Flying \n" + 
			"#718\n" + 
			"Zygarde\n" + 
			"Dragon · Ground";
}
