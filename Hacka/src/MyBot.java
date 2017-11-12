import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
 
 
 
public class MyBot extends TelegramLongPollingBot{
    int contCrocetta=0;
    long chat_id2;

    public void onUpdateReceived(Update update) {
        String quart=new String();
        quart="Crocetta";
        
        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
 
            
           /* SendMessage message1 = new SendMessage() // Create a message object object
                    .setChatId(update.getMessage().getChatId())
                    .setText("Per iniziare la sessione digita /start");*/
           
            if (update.getMessage().getText().equals("/start")) {
            		String message_text = update.getMessage().getText();
            		chat_id2 = update.getMessage().getChatId();
             		
            		getQuartiere(chat_id2);

            		if(update.getCallbackQuery().getData().equals("urlCrocetta")) {
            			quart="Crocetta";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlCentro")) {
            			quart="Centro";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlSanRita")) {
            			quart="Santa Rita";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlValentino")) {
            			quart="Valentino";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlCit")) {
            			quart="CIT Turin";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlSansa")) {
            			quart="San Salvario";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlSanP")) {
            			quart="San Paolo";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlBorgo")) {
            			quart="Borgo Crimea";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlLing")) {
            			quart="Lingotto";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlGru")) {
            			quart="Grugliasco";
            		}    	
            		if(update.getCallbackQuery().getData().equals("urlPar")) {
            			quart="Parella";
            		}    	

            		System.out.println(quart+"veeeeedi bene");
            		
            		tasti(chat_id2);
            } /*else {
 //update.getMessage().getText().equals("/ALTROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO")
            }*/
 
        } else if (update.hasCallbackQuery()) {
            
/*            String message_text_position;
            message_text_position="Crocetta";*/
          //  long chat_id2 = update.getCallbackQuery().getMessage().getChatId();
            
            if(update.getCallbackQuery().getData().equals("urlAulastudio")) {
                
          /*      if (update.hasMessage() && update.getMessage().hasText()) {
                   quart = update.getMessage().getText();
                    long chat_id = update.getMessage().getChatId();}
                
                System.out.println(quart);
          */      
                GregorianCalendar gc = new GregorianCalendar();
                int ore = gc.get(Calendar.HOUR);
                int min = gc.get(Calendar.MINUTE);
 
                //String miaprovastringa="Prova invio stringa";
                String res=new String();
                //////////////////////////////
                res=resPars("aulastudio.txt",quart ,ore,min);
                                //if(/*aulastudio*/)
                /*for(Data d:collezione) {
                    d.stampa();
                }*/
                    contCrocetta++;
          
                
                //////////////////////////////
                //res.concat("PROVACONCATAJSOADJOSAJD");
            SendMessage message1=new SendMessage() //update.getMessage().getChatId() //.setChatId(update.getCallbackQuery().getMessage().getChatId())
             .setChatId(chat_id2)
             .setText(res);
            try {
                
                execute(message1);// Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            
            
            if(contCrocetta>2) {
                
    /*            String strml="";
                strml=*/
                        //resPars("palestra.txt","Crocetta",ore,min);
                    SendMessage message5=new SendMessage() //update.getMessage().getChatId() //.setChatId(update.getCallbackQuery().getMessage().getChatId())
                             .setChatId(chat_id2)
                            .setText("Dopo il dovere c'è il divertimento...dopo tutto questo studio in Crocetta meriti un pò di svago!\n\nEcco le mie proposte:");
//                            .setText(resPars("palestra.txt","Crocetta",ore,min));
                try {
                    
                    execute(message5);// Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
                
                String strml=new String();
                strml=resPars("palestra.txt","Crocetta",ore,min);
                
                SendMessage message6=new SendMessage() //update.getMessage().getChatId() //.setChatId(update.getCallbackQuery().getMessage().getChatId())
                         .setChatId(chat_id2)
                         .setText(strml);
                        try {
                            
                            execute(message6);// Sending our message object to user
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                
            }
                        
        }
            
            /*Teatro implementation*/
            if(update.getCallbackQuery().getData().equals("urlTeatro")) {
                
                String res=new String();
                String day=new String();
                
                Calendar calendar = Calendar.getInstance();
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                if(dayOfWeek==1)
                {
                	day="Domenica";
                } else if(dayOfWeek==2)
                {
                	day="Lunedì";                	
                } else if(dayOfWeek==3)
                {
                	day="Martedì";                	
                } else if(dayOfWeek==4)
                {
                	day="Mercoledì";                	
                } else if(dayOfWeek==5)
                {
                	day="Giovedì";                	
                } else if(dayOfWeek==6)
                {
                	day="Venerdì";                	
                } else if(dayOfWeek==7) {
                	day="Sabato";                	
                };
                /*
                Calendar calendar = Calendar.getInstance();
                Date date = (Date) calendar.getTime();
                
                System.out.println(new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime()));*/
                
                res=teatroPars("teatro.txt", quart, day);
                    
                SendMessage message9=new SendMessage() //update.getMessage().getChatId()
                 .setChatId(update.getCallbackQuery().getMessage().getChatId())
                 .setText(res);
                try {
                    
                    execute(message9);// Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
                         
            if(update.getCallbackQuery().getData().equals("urlRistorante")) {
                
                GregorianCalendar gc = new GregorianCalendar();
                int ore = gc.get(Calendar.HOUR);
                int min = gc.get(Calendar.MINUTE);
                
                String str=new String();
                str=resPars("ristorante.txt",quart,ore,min);
                
                
                SendMessage message1=new SendMessage() //update.getMessage().getChatId()
                 .setChatId(update.getCallbackQuery().getMessage().getChatId())
                 .setText(str);
                try {
                    
                    execute(message1);// Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
                        
            if(update.getCallbackQuery().getData().equals("urlPalestra")) {
                
                GregorianCalendar gc = new GregorianCalendar();
                int ore = gc.get(Calendar.HOUR);
                int min = gc.get(Calendar.MINUTE);
                
                String str=new String();
                str=resPars("palestra.txt",quart,ore,min);
                
                SendMessage message1=new SendMessage() //update.getMessage().getChatId()
                 .setChatId(update.getCallbackQuery().getMessage().getChatId())
                 .setText(str);
                try {
                    
                    execute(message1);// Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            
            
            if(update.getCallbackQuery().getData().equals("urlSupermercato")) {
                
            	System.out.println(quart+"Sup");
            	
                GregorianCalendar gc = new GregorianCalendar();
                int ore = gc.get(Calendar.HOUR);
                int min = gc.get(Calendar.MINUTE);
                
                String str=new String();
                str=resPars("supermercato.txt",quart,ore,min);
                
                SendMessage message1=new SendMessage() //update.getMessage().getChatId()
                 .setChatId(update.getCallbackQuery().getMessage().getChatId())
                 .setText(str);
                try {
                    
                    execute(message1);// Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
            
            tasti(chat_id2);
        }
    }
 
    public String getBotUsername() {
        return "hellobot_Artemide_bot";
    }
 
    public String getBotToken() {
        return "451231949:AAGtKTt1jIXuLiT9-At8B2LXnpd-T0o3ROg";
    }
    
    public String resPars(String filename,String position, int h,int m){
        
        //ArrayList<Data> collezione =new ArrayList<Data>();
        //String csvFile = "/Users/mkyong/csv/country.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "-";
        String currRec="";
        int t1,t2,t,h1,h2,m1,m2;
        
        t=m+h*60;
        
        try {
            
            //String mypath="/home/g/eclipse-workspace/Bot/";
            //mypath.concat(filename);
            
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] item = line.split(cvsSplitBy);
                //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
                
                
                if(item[1].equals(position)) {
                    h1=Integer.parseInt(item[2]);
                    m1=Integer.parseInt(item[3]);
                       h2=Integer.parseInt(item[4]);
                    m2=Integer.parseInt(item[5]);
                    
                    
                    
                    t1=m1+h1*60;
                    t2=m2+h2*60;
                    
                    if( t>t1 && t<t2 )
                    {
                        for(int i=0;i<8; i++) {
                            if(!item[i].equals("null"))
                            {
                                currRec=currRec.concat(item[i]);
                                if(i==2||i==4) {
                                    currRec=currRec.concat(":");
                                } else if(i==3) {
                                    currRec=currRec.concat("/");
                                    } else if(i==0||i==1||i==5||i==6||i==7) {
                                    currRec=currRec.concat(" ");
                                }
                            //System.out.println(item[i]+" "+i+ " ");
                            }
                        }
                        currRec=currRec.concat("\n");
                    }
                }
                
                //collezione.add(new Data(item[0],item[1], item[2],item[3],item[4],item[5],item[6],item[7]));
            }
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        System.out.println(currRec);
        return currRec;
    }

public String teatroPars(String filename,String position, String day){
    
    //ArrayList<Data> collezione =new ArrayList<Data>();
    //String csvFile = "/Users/mkyong/csv/country.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = "-";
    String currRec="";

    try {
        
        //String mypath="/home/g/eclipse-workspace/Bot/";
        //mypath.concat(filename);
        
        br = new BufferedReader(new FileReader(filename));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            String[] item = line.split(cvsSplitBy);
            //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
            
            
            if(item[1].equals(position)) {
                
                if( item[7].contains(day) )
                {
                    currRec=currRec.concat(item[0]).concat(" ").concat(item[1]).concat(" ").concat(day).concat("\n");
                }
            }
        }
            
            //collezione.add(new Data(item[0],item[1], item[2],item[3],item[4],item[5],item[6],item[7]));
 
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    System.out.println(currRec);
    return currRec;
}
		

public void tasti(long chat_id2){
		
		SendMessage message = new SendMessage() // Create a message object object
		        .setChatId(chat_id2)
		        .setText("Scegli cosa ti interessa");
		InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
		
		
		List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
		
		
		
		List<InlineKeyboardButton> rowInline = new ArrayList<>();
		
		
		
		rowInline.add(new InlineKeyboardButton().setText("RISTORANTE").setCallbackData("urlRistorante"));
		rowInline.add(new InlineKeyboardButton().setText("AULASTUDIO").setCallbackData("urlAulastudio"));
		rowInline.add(new InlineKeyboardButton().setText("PALESTRA").setCallbackData("urlPalestra"));
		rowInline.add(new InlineKeyboardButton().setText("SUPERMERCATO").setCallbackData("urlSupermercato"));
		rowInline.add(new InlineKeyboardButton().setText("TEATRO").setCallbackData("urlTeatro"));
		  
		
		rowsInline.add(rowInline);
		
		
		
		// Add it to the message
		markupInline.setKeyboard(rowsInline);
		
		message.setReplyMarkup(markupInline);
		
		try {
		    
		    execute(message);// Sending our message object to user
		} catch (TelegramApiException e) {
		    e.printStackTrace();
		}
		/*} else {
		
		}
		
		} else if (update.hasCallbackQuery()) {
		
		String message_text_position;
		message_text_position="Crocetta";
		long chat_id2 = update.getCallbackQuery().getMessage().getChatId();
		
		if(update.getCallbackQuery().getData().equals("urlAulastudio")) {


*/
		
	}

public void getQuartiere(long chat_id2){
	
	SendMessage message = new SendMessage() // Create a message object object
	        .setChatId(chat_id2)
	        .setText("In quale quartiere sei?");
	
	InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
	List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
	List<InlineKeyboardButton> rowInline = new ArrayList<>();
	
	
	rowInline.add(new InlineKeyboardButton().setText("CROCETTA").setCallbackData("urlCrocetta"));
	rowInline.add(new InlineKeyboardButton().setText("CENTRO").setCallbackData("urlCentro"));
	rowInline.add(new InlineKeyboardButton().setText("SAN SALVARIO").setCallbackData("urlSansa"));
	rowInline.add(new InlineKeyboardButton().setText("VALENTINO").setCallbackData("urlValentino"));
	rowInline.add(new InlineKeyboardButton().setText("CIT TURIN").setCallbackData("urlCit"));
	rowInline.add(new InlineKeyboardButton().setText("SAN PAOLO").setCallbackData("urlSanP"));
	rowInline.add(new InlineKeyboardButton().setText("BORGO CRIMEA").setCallbackData("urlBorgo"));
	rowInline.add(new InlineKeyboardButton().setText("LINGOTTO").setCallbackData("urlLing"));
	rowInline.add(new InlineKeyboardButton().setText("SANTA RITA").setCallbackData("urlSanRita"));
	rowInline.add(new InlineKeyboardButton().setText("GRUGLIASCO").setCallbackData("urlGru"));
	rowInline.add(new InlineKeyboardButton().setText("PARELLA").setCallbackData("urlPar"));
	
	  
	
	rowsInline.add(rowInline);
	
	
	
	// Add it to the message
	markupInline.setKeyboard(rowsInline);
	
	message.setReplyMarkup(markupInline);
	
	try {
	    
	    execute(message);// Sending our message object to user
	} catch (TelegramApiException e) {
	    e.printStackTrace();
	} 

}

}
