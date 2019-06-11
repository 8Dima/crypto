package kryptoV2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;




public class kryptopr extends JFrame
{

	

	
		//Текст пользователя
		static String textpolz="";

		
		
		
		//Конечеый текст
		static String textkn="";
		
		
		
		//Изображения
		static Image helpimg1, helpimg2, helpimg3, helpimg4, kssImg, background;
		
		
		
		//Номер текущей буквы
		static int nombukvi;
		
		
		
		//Выбранная позиция списка
		static int numbersel=-1;
		
		
		
		static int chr;
		
		
		JEditorPane about;


		static String end_text;

		//Текстовые поля
		JTextArea text,text_shifr;
		
		
		
		//Поле для ключа
		JTextField vvk;
		
		
		
		//Чек бокс
		JCheckBox shifr_or_deshifr;
		
		
		
		JButton btn_text_from_file,btn_text_to_file;
		
		
		//Кнопка сохранения параметров
		JButton save_settings;
		
		
		//Кнопки
		JButton exit;
		
		//Скроллы для текстовых полей
		JScrollPane scroll, scroll2,scroll3;
		
		
		
		//Список (меню) с шифрами
		JList list;
		
		//URL для html шифров
		URL URL_WITH_TEXT;
		
		
		//Переменные для ключа
		String kluchstr;
		int kluchint;
		
		//Язык. 0 - русский, 1 - английский
		int lang=0;
		
		//Стандартный и зашифрованный тексты
		static String standart_text,krypto_text;
		
		JLabel[] label = new JLabel[10];
		
		//Стиль для текста
		static Font textFont = new Font("arial",3,20);
		
		
		
		static int[] kluch2 = new int[1000000];
		
		
		static int nombukvi2;
		
		char[] rusalph = { 1040, 1072, 1041, 1073, 1042, 1074, 1043, 1075, 1044, 1076,
				1045, 1077, 1025, 1105, 1046, 1078, 1047, 1079, 1048, 1080, 1049, 1081, 1050, 1082,
				1051, 1083, 1052, 1084, 1053, 1085, 1054, 1086, 1055, 1087, 1056, 1088,
				1057, 1089, 1058, 1090, 1059, 1091, 1060, 1092, 1061, 1093, 1062, 1094,
				1063, 1095, 1064, 1096, 1065, 1097, 1066, 1098, 1067, 1099, 1068, 1100, 
				1069, 1101, 1070, 1102, 1071, 1103};
		
		
		atbash atbash = new atbash();	
		cesar cesar = new cesar();
		kluch kluch = new kluch();
		MD5 MD5 = new MD5();
		SHA SHA = new SHA();
		vijener vijener = new vijener();
		
		
		
		 

	//Ширина экрана
	int screenWidth;
	
	//Один процент от ширины
	int one_percentage_of_the_width;

	
	//Высота экрана
    int screenHeight;
    
    //Один процент от высоты
    int one_percentage_of_the_height;
	
	public kryptopr()
	{		
		setTitle("Крипто");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		//super(new JFrame(){@Override public boolean isShowing(){return true;}});
		

		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 
		 
		 GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();

		 GraphicsDevice[] devices = environment.getScreenDevices();

		 
		 
		 
		  for (int i=0; i<devices.length; i++) {

		        DisplayMode dmode = devices[i].getDisplayMode();

		        screenWidth = dmode.getWidth();

		        screenHeight = dmode.getHeight();

		    }
		 
		  
		  
		  
		  setSize(screenWidth,screenHeight);
			setVisible(true);
			
			
			//JPanels
			JPanel shifr_select_pane = new JPanel();
			JPanel shifr_settings_pane = new JPanel();
			JPanel text_enter_pane = new JPanel();
			JPanel tests = new JPanel();
			
			
			
			//Containers
			Container con = getContentPane();
			con.add(shifr_select_pane);
			con.add(shifr_settings_pane);
			con.add(text_enter_pane);
			con.add(tests);
			
			shifr_select_pane.setLayout(null);
			text_enter_pane.setLayout(null);
			shifr_settings_pane.setLayout(null);
			tests.setLayout(null);
			
			
			JTabbedPane leftpanes = new JTabbedPane();
			leftpanes.setTabPlacement(JTabbedPane.LEFT);
			
			con.add(leftpanes);
			
			leftpanes.addTab("                     Выбор шифра                       ", shifr_select_pane);
			leftpanes.addTab("Параметры шифрования/дешифрования", shifr_settings_pane);
			leftpanes.addTab("Ввод текста", text_enter_pane);
			leftpanes.addTab("Тесты", tests);
			
			
			
			 leftpanes.addMouseListener(new MouseAdapter() {
		            public void mouseClicked(MouseEvent e) {
		               
		                int idx = ((JTabbedPane)e.getSource()).indexAtLocation(e.getX(), e.getY());

		                if (idx == 2) {
		                	
		                
		                }
		                //System.out.println(idx);
		            }
		        });
			
			
			
			one_percentage_of_the_height=shifr_select_pane.getHeight()/100;
			one_percentage_of_the_width=shifr_select_pane.getWidth()/100;
			
			
			
			
			
			String[] spisok = { "Информация",
					"Атбаш",
					"Шифр Цезаря",
					"Шифр Виженера",
					"MD2","MD5",
					"SHA-1","SHA-256",
					"SHA-384","SHA-512"};

			list = new JList(spisok);
			list.setLayoutOrientation(JList.VERTICAL);		
			list.setFont(textFont);
			list.setVisible(true);
			list.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
			list.setBackground(new Color(222, 214, 255));
			list.addMouseListener(new MouseAdapter() {
		            public void mouseClicked(MouseEvent e) {
		                if ( e.getClickCount() == 2 ) {
		                	numbersel=list.getSelectedIndex();
		                	
		                	if (numbersel == 0) 
		                	{
		                		URL URL_WITH_TEXT = getClass().getResource("html_texts/info.html");
		                		try {
		                            about.setPage(URL_WITH_TEXT);
		                        } catch (Exception ee) {
		                            JOptionPane.showMessageDialog(kryptopr.this, 
		                                                          "FAIL");
		                        }
		                	}
		                	
		                	else if (numbersel == 1) 
		                	{
		                		URL URL_WITH_TEXT = getClass().getResource("html_texts/atbash.html");
		                		try {
		                            about.setPage(URL_WITH_TEXT);
		                        } catch (Exception ee) {
		                            JOptionPane.showMessageDialog(kryptopr.this, 
		                                                          "FAIL");
		                        }
		                		
		                		
		                	}
		                	else if (numbersel == 2)
		                	{
		                		URL URL_WITH_TEXT = getClass().getResource("html_texts/cesar.html");
		                		try {
		                            about.setPage(URL_WITH_TEXT);
		                        } catch (Exception ee) {
		                            JOptionPane.showMessageDialog(kryptopr.this, 
		                                                          "FAIL");
		                        }
		                		
		                		
		                		
		                		vvk.setEditable(true);
		                	}
		                	else if (numbersel == 3) 
		                	{
		                		URL URL_WITH_TEXT = getClass().getResource("html_texts/vijener.html");
		                		try {
		                            about.setPage(URL_WITH_TEXT);
		                        } catch (Exception ee) {
		                            JOptionPane.showMessageDialog(kryptopr.this, 
		                                                          "FAIL");
		                        }
		                		
		                		vvk.setEditable(true);
		                	}
		                	else if (numbersel == 4) 
		                	{
		                		URL URL_WITH_TEXT = getClass().getResource("html_texts/MD2.html");
		                		try {
		                            about.setPage(URL_WITH_TEXT);
		                        } catch (Exception ee) {
		                            JOptionPane.showMessageDialog(kryptopr.this, 
		                                                          "FAIL");
		                        }
		                	}
		                	else if (numbersel == 5) 
		                	{
		                		
			                		URL URL_WITH_TEXT = getClass().getResource("html_texts/MD5.html");
			                		try {
			                            about.setPage(URL_WITH_TEXT);
			                        } catch (Exception ee) {
			                            JOptionPane.showMessageDialog(kryptopr.this, 
			                                                          "FAIL");
			                        }
			                	
		                	}
		                	else if (numbersel == 6) 
		                	{
		                		
			                		URL URL_WITH_TEXT = getClass().getResource("html_texts/SHA1.html");
			                		try {
			                            about.setPage(URL_WITH_TEXT);
			                        } catch (Exception ee) {
			                            JOptionPane.showMessageDialog(kryptopr.this, 
			                                                          "FAIL");
			                        }
			                	
		                	}
		                	else if (numbersel == 7) 
		                	{
		                		
			                		URL URL_WITH_TEXT = getClass().getResource("html_texts/SHA256.html");
			                		try {
			                            about.setPage(URL_WITH_TEXT);
			                        } catch (Exception ee) {
			                            JOptionPane.showMessageDialog(kryptopr.this, 
			                                                          "FAIL");
			                        }
			                	
		                	}
		                	else if (numbersel == 8) 
		                	{
		                		
			                		URL URL_WITH_TEXT = getClass().getResource("html_texts/SHA384.html");
			                		try {
			                            about.setPage(URL_WITH_TEXT);
			                        } catch (Exception ee) {
			                            JOptionPane.showMessageDialog(kryptopr.this, 
			                                                          "FAIL");
			                        }
			                	
		                	}
		                	else if (numbersel == 9) 
		                	{
		                		
			                		URL URL_WITH_TEXT = getClass().getResource("html_texts/SHA512.html");
			                		try {
			                            about.setPage(URL_WITH_TEXT);
			                        } catch (Exception ee) {
			                            JOptionPane.showMessageDialog(kryptopr.this, 
			                                                          "FAIL");
			                        }
			                	
		                	}	
		                }
		            }
		        });
			
			shifr_select_pane.add(list);
			
			
			
			
		                 
		      
		        		

			//vvk.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
			//vvk.setBackground(new Color(222, 214, 255));

			
			
			
///////////////////////////Элементы панели с выбором шифра////////////////////////////////////////////
			about = new JEditorPane();
			about.setVisible(true);
			about.setEditable(false);
			about.setFont(textFont);
			about.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
			about.setBackground(new Color(222, 214, 255));
			about.setContentType("text/html");
			scroll=new JScrollPane(about);
			shifr_select_pane.add(scroll);
			
			
			
			

			list.setBounds(0,
						   0, 
						   shifr_select_pane.getWidth()/100*20 , 
						   shifr_select_pane.getHeight()/100*85);
			about.setBounds(shifr_select_pane.getWidth()/100*20+shifr_select_pane.getWidth()/100*10,
							0,
							shifr_select_pane.getWidth()/100*60,
							shifr_select_pane.getHeight()/100*85);
			
			
			scroll.setBounds(shifr_select_pane.getWidth()/100*20+shifr_select_pane.getWidth()/100*5,
					0,
					shifr_select_pane.getWidth()/100*60,
					shifr_select_pane.getHeight()/100*85);
			
			
			
			
			
			
			
			
			

///////////////////////////Элементы панели с вводом текста////////////////////////////////////////////
	
			  
	    
			
			
         	
		    
   btn_text_from_file = new JButton("Открыть файл");
   btn_text_from_file.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
   btn_text_from_file.setBackground(new Color(222, 214, 255));
   btn_text_from_file.setVisible(true); 
   text_enter_pane.add(btn_text_from_file);
   btn_text_from_file.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
			JFileChooser fileopen = new JFileChooser();

			int d = fileopen.showDialog(null,"Открыть текст");
			if (d == JFileChooser.APPROVE_OPTION)
			{
				File file = fileopen.getSelectedFile();
				String txt_file="";
				try {
		            Scanner in = new Scanner(file);
		            
		            while (in.hasNextLine()) {
		                txt_file+=in.nextLine();
		                txt_file+="\n";
		            }
		            in.close();
		        } catch (FileNotFoundException ex) {
		            JOptionPane.showMessageDialog(null, "Файл не найден или доступ закрыт");
		        }
				text.setText(txt_file);
			}
		}
		
	});
   btn_text_to_file = new JButton("Сохранить результат");
   btn_text_to_file.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
   btn_text_to_file.setBackground(new Color(222, 214, 255));
   btn_text_to_file.setVisible(true); 
   text_enter_pane.add(btn_text_to_file);
   btn_text_to_file.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, "Удостоверьтесь, что расширение файла txt");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("*.TXT","*.*");
	        JFileChooser file_saver = new JFileChooser();
	        file_saver.setFileFilter(filter);
	        if ( file_saver.showSaveDialog(null) == JFileChooser.APPROVE_OPTION ) {
	            try ( FileWriter fw = new FileWriter(file_saver.getSelectedFile()) ) {
	                fw.write(text_shifr.getText());
	            }
	            catch ( IOException e ) {
	            	JOptionPane.showMessageDialog(null, "Возможно, отказано в доступе =(");
	            }
	        }
		}
		
	});
			
			
			text = new JTextArea("");
			text.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
			text.setBackground(new Color(222, 214, 255));
			text.setLineWrap(true);
			text.setWrapStyleWord(true);
			text.setFont(textFont);
			scroll2 = new JScrollPane(text);
			text_enter_pane.add(scroll2);
			text.addKeyListener( new KeyListener() {
		        public void keyTyped( KeyEvent ev ) {
		         
		         
		         
		         
		        }
		        @Override
		        public void keyPressed(KeyEvent ev) {
		        	int key = ev.getKeyCode();
		        	 if (numbersel == -1)  {text_shifr.setText(text.getText());}
		        	 else if (numbersel == 0)  {text_shifr.setText(text.getText());}
		        	 else if (numbersel ==  1 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(atbash.shifr(text.getText(),lang));}
		        	 else if (numbersel ==  1 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {text_shifr.setText(atbash.deshifr(text.getText(),lang));}
		        	 else if (numbersel ==  2 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(cesar.shifr(text.getText(),kluchint,lang));}
		        	 else if (numbersel ==  2 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {text_shifr.setText(cesar.deshifr(text.getText(),kluchint,lang));}
		        	 else if (numbersel ==  3 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(vijener.shifr(text.getText(),kluchstr,lang));}
		        	 else if (numbersel ==  3 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {text_shifr.setText(vijener.deshifr(text.getText(),kluchstr,lang));}
		        	 else if (numbersel ==  4 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(MD5.md2hex_create(text.getText()));}
		        	 else if (numbersel ==  4 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {JOptionPane.showMessageDialog(null, "MD2 не подлежит расшифровке!");}
		        	 else if (numbersel ==  5 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(MD5.md5hex_create(text.getText()));}
		        	 else if (numbersel ==  5 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {JOptionPane.showMessageDialog(null, "MD5 не подлежит расшифровке!");}
		        	 else if (numbersel ==  6 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(SHA.SHA1hex_create(text.getText()));}
		        	 else if (numbersel ==  6 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {JOptionPane.showMessageDialog(null, "SHA-1 не подлежит расшифровке!");}
		        	 else if (numbersel ==  7 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(SHA.SHA256hex_create(text.getText()));}
		        	 else if (numbersel ==  7 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {JOptionPane.showMessageDialog(null, "SHA-256 не подлежит расшифровке!");}
		        	 else if (numbersel ==  8 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(SHA.SHA384hex_create(text.getText()));}
		        	 else if (numbersel ==  8 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {JOptionPane.showMessageDialog(null, "SHA-384 не подлежит расшифровке!");}
		        	 else if (numbersel ==  9 && ((key == KeyEvent.VK_B && ev.isControlDown()) || key == KeyEvent.VK_F7) )   {text_shifr.setText(SHA.SHA512hex_create(text.getText()));}
		        	 else if (numbersel ==  9 && ((key == KeyEvent.VK_N && ev.isControlDown()) || key == KeyEvent.VK_F8) )   {JOptionPane.showMessageDialog(null, "SHA-512 не подлежит расшифровке!");}
		        
		        }
		        @Override
		        public void keyReleased(KeyEvent ev) {
		        	
		        	 
			        
		        }    
		    });
			
			
			text_shifr = new JTextArea("");
			text_shifr.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
			text_shifr.setBackground(new Color(222, 214, 255));
			text_shifr.setLineWrap(true);
			text_shifr.setWrapStyleWord(true);
			text_shifr.setFont(textFont);
			scroll3 = new JScrollPane(text_shifr);
			text_enter_pane.add(scroll3);
			
			
		  
			
			text.setBounds(text_enter_pane.getWidth()/100*5,
						   text_enter_pane.getHeight()/100*5,
						   text_enter_pane.getWidth()/100*80,
						   text_enter_pane.getHeight()/100*40);
			
			text_shifr.setBounds(text_enter_pane.getWidth()/100*5,
								 text_enter_pane.getHeight()/100*50,
								 text_enter_pane.getWidth()/100*80,
								 text_enter_pane.getHeight()/100*40);
			
		  
		  
			scroll2.setBounds(text_enter_pane.getWidth()/100*5,
						   text_enter_pane.getHeight()/100*5,
						   text_enter_pane.getWidth()/100*80,
						   text_enter_pane.getHeight()/100*40);
	
			scroll3.setBounds(text_enter_pane.getWidth()/100*5,
								 text_enter_pane.getHeight()/100*50,
								 text_enter_pane.getWidth()/100*80,
								 text_enter_pane.getHeight()/100*40);
			
			btn_text_from_file.setBounds(text_enter_pane.getWidth()/100*86,
									  text_enter_pane.getHeight()/100*5,
									  text_enter_pane.getWidth()/100*10,
									  text_enter_pane.getHeight()/100*5);
			
			btn_text_to_file.setBounds(text_enter_pane.getWidth()/100*86,
					  text_enter_pane.getHeight()/100*15,
					  text_enter_pane.getWidth()/100*10,
					  text_enter_pane.getHeight()/100*5);

		
		
		
///////////////////////////Элементы панели с вводом параметров////////////////////////////////////////////
			
			
			
			
			for (int i=0; i<2; i++){
			label[i] = new JLabel("");
			shifr_settings_pane.add(label[i]);
			}
			
			
			label[0].setText("Ключ");
			label[1].setText("Язык : Русский");
			
			
			vvk = new JTextField();
			vvk.setVisible(true);
			vvk.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
			vvk.setBackground(new Color(222, 214, 255));
			vvk.setEditable(true);
			shifr_settings_pane.add(vvk);
		
			
			
			
			
			save_settings = new JButton("Сохранить параметры");
			save_settings.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
			save_settings.setBackground(new Color(222, 214, 255));
			shifr_settings_pane.add(save_settings);
			save_settings.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (numbersel==-1){}
					else if (numbersel==1){}
					else if (numbersel==2){kluchint = kluch.check_cesar(vvk.getText());}
					else if (numbersel==3){kluchstr = kluch.check_vijener(vvk.getText());}
					
	
					
				}
					
			});
		
		
			JComboBox<String> language = new JComboBox<String>();
			language.addItem("Русский");
			language.addItem("Английский");
			language.setBorder(BorderFactory.createLineBorder(new Color(93,0,255)));
			language.setBackground(new Color(222, 214, 255));
			language.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					lang =  language.getSelectedIndex();
					if (lang==0) label[1].setText("Язык : Русский");
					else if (lang == 1) label[1].setText("Язык : Английский");
				}
				
					
				
			});
			shifr_settings_pane.add(language);
			
			vvk.setBounds(shifr_settings_pane.getWidth()/100*1,
						  shifr_settings_pane.getHeight()/100*2,
						  shifr_settings_pane.getWidth()/100*7,
						  shifr_settings_pane.getHeight()/100*5);
			
			label[0].setBounds(shifr_settings_pane.getWidth()/100*1,
						  shifr_settings_pane.getHeight()/100*0,
						  shifr_settings_pane.getWidth()/100*5,
						  shifr_settings_pane.getHeight()/100*2);
			
			
			language.setBounds(shifr_settings_pane.getWidth()/100*10,
					  shifr_settings_pane.getHeight()/100*2,
					  shifr_settings_pane.getWidth()/100*7,
					  shifr_settings_pane.getHeight()/100*5);
			
			label[1].setBounds(shifr_settings_pane.getWidth()/100*10,
					  shifr_settings_pane.getHeight()/100*0,
					  shifr_settings_pane.getWidth()/100*8,
					  shifr_settings_pane.getHeight()/100*2);
			
			
			
			save_settings.setBounds(shifr_settings_pane.getWidth()/100*80,
									shifr_settings_pane.getHeight()/100*85,
									shifr_settings_pane.getWidth()/100*17,
									shifr_settings_pane.getHeight()/100*5);
			
			
			
			
			
			
			
			
			
		URL urlico1 = getClass().getResource("image/icon1616.png");
		URL urlico2 = getClass().getResource("image/icon3232.png");
        ArrayList<Image> iCont = new ArrayList<Image>();
        iCont.add(new ImageIcon(urlico1).getImage());
        iCont.add(new ImageIcon(urlico2).getImage());
        setIconImages(iCont);
        
		
	}
	
    
	public static void main(String[] args) 
	{
		kryptopr kryptopr = new kryptopr();
	}
}


	
