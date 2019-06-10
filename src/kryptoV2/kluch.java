package kryptoV2;

import java.io.IOException;

import javax.swing.JOptionPane;

public class kluch {
	int kluch_int;
	String kluch_str;
	
	char[] rusalph = { 1040, 1072, 1041, 1073, 1042, 1074, 1043, 1075, 1044, 1076,
			1045, 1077, 1025, 1105, 1046, 1078, 1047, 1079, 1048, 1080, 1049, 1081, 1050, 1082,
			1051, 1083, 1052, 1084, 1053, 1085, 1054, 1086, 1055, 1087, 1056, 1088,
			1057, 1089, 1058, 1090, 1059, 1091, 1060, 1092, 1061, 1093, 1062, 1094,
			1063, 1095, 1064, 1096, 1065, 1097, 1066, 1098, 1067, 1099, 1068, 1100, 
			1069, 1101, 1070, 1102, 1071, 1103};
	
	char[] anglalph = { 65, 97, 66, 98, 67, 99, 68, 100, 69, 101, 70, 102, 71, 103, 72, 104, 73, 105,
			74, 106, 75, 107, 76, 108, 77, 109, 78, 110, 79, 111, 80, 112, 81, 113, 82, 114, 83, 115,
			84, 116, 85, 117, 86, 118, 87, 119, 88, 120, 89, 121, 90, 122};
	
	public int check_cesar(String a) 
	{
			
				try
				{
					kluch_int = Integer.parseInt(a);
					if (kluch_int<=0 || kluch_int>=65)
					{
						JOptionPane.showMessageDialog(null, "���� �� ������������� ������� 0<����<65");
						kluch_int=1;
					}
				}
				catch(NumberFormatException nf){JOptionPane.showMessageDialog(null, "���� ������ ���� ����� ������!");}
				
			return kluch_int;
				
			
	
	}
	public String check_vijener(String a)
	{
		
		try
		{
			kluch_str=a;
			char kl[]=kluch_str.toCharArray();
			for (int i=0; i<=kluch_str.length(); i++)
			{
			}
		}
		catch(NumberFormatException nf){JOptionPane.showMessageDialog(null, "���� ������ �������� �� ����!");}
		
		
		return kluch_str;
	}
	
}
