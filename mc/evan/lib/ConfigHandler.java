package mc.evan.lib;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler {

	public static final String IDS = "ID Configuration";
	
	public static void init(File file){
		Configuration config = new Configuration(file);
		
		config.load();
		
		ID.HCOMP = config.get(IDS, Names.HCOMP_IG, ID.HCOMP_DEFAULT).getInt();
		ID.CPICK = config.get(IDS, Names.CPICK_IG, ID.CPICK_DEFAULT).getInt() - 256;
		ID.ZERO = config.get(IDS, Names.ZERO_IG, ID.ZERO_DEFAULT).getInt() - 256;
		ID.ONE = config.get(IDS, Names.ONE_IG, ID.ONE_DEFAULT).getInt() - 256;
		ID.TWO = config.get(IDS, Names.TWO_IG, ID.TWO_DEFAULT).getInt() - 256;
		ID.FOUR = config.get(IDS, Names.FOUR_IG, ID.FOUR_DEFAULT).getInt() - 256;
		ID.EIGHT = config.get(IDS, Names.EIGHT_IG, ID.EIGHT_DEFAULT).getInt() - 256;
		
		
		config.save();
		
		
	}
}
