package kryptoV2;


import javax.swing.JOptionPane;

class kluch {
	private int kluch_int;
	private String kluch_str;

	
	int check_cesar(String a)
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
	String check_vijener(String a)
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
