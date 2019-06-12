package kryptoV2;



class atbash {
	
	
	private char[] rusalph = { 1040, 1072, 1041, 1073, 1042, 1074, 1043, 1075, 1044, 1076,
			1045, 1077, 1025, 1105, 1046, 1078, 1047, 1079, 1048, 1080, 1049, 1081, 1050, 1082,
			1051, 1083, 1052, 1084, 1053, 1085, 1054, 1086, 1055, 1087, 1056, 1088,
			1057, 1089, 1058, 1090, 1059, 1091, 1060, 1092, 1061, 1093, 1062, 1094,
			1063, 1095, 1064, 1096, 1065, 1097, 1066, 1098, 1067, 1099, 1068, 1100, 
			1069, 1101, 1070, 1102, 1071, 1103};
	
	private char[] anglalph = { 65, 97, 66, 98, 67, 99, 68, 100, 69, 101, 70, 102, 71, 103, 72, 104, 73, 105,
			74, 106, 75, 107, 76, 108, 77, 109, 78, 110, 79, 111, 80, 112, 81, 113, 82, 114, 83, 115,
			84, 116, 85, 117, 86, 118, 87, 119, 88, 120, 89, 121, 90, 122};
	
	
	private int int_simv,nomer_bukvi,f=0;
	private String end_text;
	String shifr(String s, int lang)
	{

		f=0;
		char simv[] = s.toCharArray();
		end_text="";

		
		while (f < simv.length) 
		{
			nomer_bukvi=-1;
			if (lang == 0) {
		for (int i=0; i<66; i++) 
		{
		
		
		if ((int)simv[f]==rusalph[i]) 
  		 {
  			nomer_bukvi=64 - i + 1;
  			end_text=end_text+(char)rusalph[nomer_bukvi];
  		 }
		}
	}
			else if (lang==1) {
   	 for (int i=0; i<52; i++) 
   	 {
   		 if ((int)simv[f]==anglalph[i]) 
   		 {
   			
   			nomer_bukvi=50 - i + 1;
  			end_text=end_text+(char)anglalph[nomer_bukvi]; 
   		 }				        		 
   	 }
	}
   	 if (nomer_bukvi==-1)
   	 {
   		 end_text=end_text+(char)simv[f];
   	 }
   	 
   	 f++;
	}
   	 

		return end_text;
	}
	
	String deshifr(String s,int lang)
	{
		
		
				f=0;
				char simv[] = s.toCharArray();
				end_text="";

				
				while (f < simv.length) 
				{
					nomer_bukvi=-1;
				for (int i=0; i<66; i++) 
				{
				
				
				if ((int)simv[f]==rusalph[i]) 
		  		 {
		  			nomer_bukvi=64 - i + 1;
		  			end_text=end_text+(char)rusalph[nomer_bukvi];
		  		 }
				}
				 
		   	 
		   	 for (int i=0; i<52; i++) 
		   	 {
		   		 if ((int)simv[f]==anglalph[i]) 
		   		 {
		   			
		   			nomer_bukvi=50 - i + 1;
		  			end_text=end_text+(char)anglalph[nomer_bukvi]; 
		   		 }				        		 
		   	 }
		   	 
		   	 if (nomer_bukvi==-1)
		   	 {
		   		 end_text=end_text+(char)simv[f];
		   	 }
		   	 
		   	 f++;
			}
		   	 

				return end_text;
		
	}
}
