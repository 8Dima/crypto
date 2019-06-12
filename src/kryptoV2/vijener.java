package kryptoV2;

class vijener {
	private char[] rusalph = { 1040, 1072, 1041, 1073, 1042, 1074, 1043, 1075, 1044, 1076,
			1045, 1077, 1025, 1105, 1046, 1078, 1047, 1079, 1048, 1080, 1049, 1081, 1050, 1082,
			1051, 1083, 1052, 1084, 1053, 1085, 1054, 1086, 1055, 1087, 1056, 1088,
			1057, 1089, 1058, 1090, 1059, 1091, 1060, 1092, 1061, 1093, 1062, 1094,
			1063, 1095, 1064, 1096, 1065, 1097, 1066, 1098, 1067, 1099, 1068, 1100, 
			1069, 1101, 1070, 1102, 1071, 1103};
	
	private char[] anglalph = { 65, 97, 66, 98, 67, 99, 68, 100, 69, 101, 70, 102, 71, 103, 72, 104, 73, 105,
			74, 106, 75, 107, 76, 108, 77, 109, 78, 110, 79, 111, 80, 112, 81, 113, 82, 114, 83, 115,
			84, 116, 85, 117, 86, 118, 87, 119, 88, 120, 89, 121, 90, 122};
	
	private int f=0, kluch_nom=0, kluch_index, nom_bukvi;
	private String end_text;
	
	String shifr(String a, String kluch, int lang)
	{
		
		char simv[] = a.toCharArray();
		char klch[] = kluch.toCharArray();
		f=0;
		end_text="";
		kluch_index=0;
		kluch_nom=0;
		
		while (f < simv.length) 
		{
			nom_bukvi=-1;
			if (lang == 0)
			{
				
				for (int i=0; i<66; i++) if ((int)klch[kluch_nom] == rusalph[i])  kluch_index=i;
					
				for (int i=0; i<66; i++) 
				{
				
				
				if ((int)simv[f]==rusalph[i]) 
		  		 {
					nom_bukvi=(i+kluch_index) % 65;
		  			end_text=end_text+rusalph[nom_bukvi];
		  			
		  			if (kluch_nom<klch.length-1){kluch_nom++;}else kluch_nom=0;
		  			
		  			
		  		 }
				}
				
			}
			
			else if (lang == 1)
			{
				for (int i=0; i<52; i++) if ((int)klch[kluch_nom] == anglalph[i])  kluch_index=i;
				
				for (int i=0; i<52; i++) 
				{
				
				
				if ((int)simv[f]==anglalph[i]) 
		  		 {
					nom_bukvi=(i+kluch_index) % 51;
		  			end_text=end_text+anglalph[nom_bukvi];
		  			
		  			if (kluch_nom<klch.length-1){kluch_nom++;}else kluch_nom=0;
		  			
		  			
		  		 }
				}
			}
			
			if (nom_bukvi==-1)
		   	 {
		   		 end_text=end_text+simv[f];
		   	 }
			
			f++;
			
		}
		
		
		
		return end_text;
	}
	
	
	String deshifr(String a, String kluch, int lang)
	{
		
		char simv[] = a.toCharArray();
		char klch[] = kluch.toCharArray();
		f=0;
		end_text="";
		kluch_index=0;
		kluch_nom=0;
		
		while (f < simv.length) 
		{
			nom_bukvi=-1;
			if (lang == 0)
			{
				
				for (int i=0; i<66; i++) if ((int)klch[kluch_nom] == rusalph[i])  kluch_index=i;
					
				for (int i=0; i<66; i++)
				{
				if ((int)simv[f]==rusalph[i]) 
		  		 {
					nom_bukvi=(i-kluch_index) % 66;
					if (nom_bukvi<0)nom_bukvi*=-1;
					
					
		  			end_text=end_text+rusalph[nom_bukvi];
		  			
		  			if (kluch_nom<klch.length-1){kluch_nom++;}else kluch_nom=0;
		  			
		  			
		  		 }
				}
				
			}
			
			else if (lang == 1)
			{
				for (int i=0; i<52; i++) if ((int)klch[kluch_nom] == anglalph[i])  kluch_index=i;
				
				for (int i=0; i<52; i++) 
				{
				
				
				if ((int)simv[f]==anglalph[i]) 
		  		 {
					nom_bukvi=(i-kluch_index) % 52;
		  			end_text=end_text+anglalph[nom_bukvi];
		  			
		  			if (kluch_nom<klch.length-1){kluch_nom++;}else kluch_nom=0;
		  			
		  			
		  		 }
				}
			}
			
			if (nom_bukvi==-1)
		   	 {
		   		 end_text=end_text+simv[f];
		   	 }
			
			f++;
			
		}
		
		
		
		return end_text;
	}
	
	
}
