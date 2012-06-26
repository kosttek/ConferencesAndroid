package pl.edu.kosttek.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.ksoap2.serialization.SoapObject;

import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.entity.BaseObject;
import pl.edu.kosttek.entity.Boardroom;
import pl.edu.kosttek.entity.Conference;
import pl.edu.kosttek.entity.Panel;
import pl.edu.kosttek.entity.Presentation;
import pl.edu.kosttek.entity.Schedule;
import pl.edu.kosttek.entity.Speaker;

public class EntityParser {
	
	static protected Set <Conference> confernecesTemp = new HashSet<Conference>();
	static protected Set <Boardroom> boardroomsTemp= new HashSet<Boardroom>();
	static protected Set <Panel> panelsTemp = new HashSet<Panel>();
	static protected Set <Presentation> presentationsTemp = new HashSet<Presentation>();
	static protected Set <Schedule> schedulesTemp= new HashSet<Schedule>();
	static protected Set <Speaker> speakersTemp = new HashSet<Speaker>();
	
	public static void setupParser(){
		 confernecesTemp = new HashSet<Conference>();
		 boardroomsTemp= new HashSet<Boardroom>();
		 panelsTemp = new HashSet<Panel>();
		 presentationsTemp = new HashSet<Presentation>();
		 schedulesTemp= new HashSet<Schedule>();
		 speakersTemp = new HashSet<Speaker>();
		confernecesTemp.addAll(ConferencesAndroid.getConferneces());
		boardroomsTemp.addAll(ConferencesAndroid.getBoardrooms());
		panelsTemp.addAll(ConferencesAndroid.getPanels());
		presentationsTemp.addAll(ConferencesAndroid.getPresentations());
		schedulesTemp.addAll(ConferencesAndroid.getSchedules());
		speakersTemp.addAll(ConferencesAndroid.getSpeakers());
	}
	
	public static void setupResults(){
		/*
		 * debug
		 */
		 Set <Conference> confernecesTempdbg = confernecesTemp;
		 Set <Boardroom> boardroomsTempdbg= boardroomsTemp;
		 Set <Panel> panelsTempdbg = panelsTemp;
		 Set <Presentation> presentationsTempdbg = presentationsTemp; 
		 Set <Schedule> schedulesTempdbg= schedulesTemp;
		 Set <Speaker> speakersTempdbg = speakersTemp;
		
		/*
		 * debug
		 */
		ConferencesAndroid.setConferneces(new ArrayList(confernecesTemp));
		ConferencesAndroid.setBoardrooms(new ArrayList(boardroomsTemp));
		ConferencesAndroid.setPanels(new ArrayList(panelsTemp));
		ConferencesAndroid.setPresentations(new ArrayList(presentationsTemp));
		ConferencesAndroid.setSchedules(new ArrayList(schedulesTemp));
		ConferencesAndroid.setSpeakers(new ArrayList(speakersTemp));
	}
	public static BaseObject getObjectWithId(int id, Set list){
		for(Object bo : list){
			if(((BaseObject)bo).getId()==id){
				return (BaseObject) bo;
			}
		}
		return null;			
	}
	public static boolean checkIfObjectIsInList(BaseObject baseO, Set list){
		int id = baseO.getId();
		for(Object bo : list){
			if(((BaseObject)bo).getId()==id){
				return true;
			}
		}
		return false;
	}
	
	static  void  foo2(List<BaseObject> l){	
	}

	public static Conference parseConfernece(SoapObject item) {

		Date startDate = (Date)getExactProperty("startDate",Conference.class,item);
		Date endDate =(Date)getExactProperty("endDate",Conference.class,item); 		
		String title = (String)getExactProperty("title",Conference.class,item);
		String description =(String)getExactProperty("description",Conference.class,item);
		
		Conference conf = new Conference(title, description, startDate, endDate);
		
		conf.setId(Integer.parseInt(item.getProperty("id").toString()));
		if(!checkIfObjectIsInList(conf,confernecesTemp)){
			confernecesTemp.add(conf);
		}
		return conf;
	}
	
	public static Boardroom parseBoardroom(SoapObject item) {

		String name = (String)getExactProperty("name",Boardroom.class,item);
		String title = (String)getExactProperty("title",Boardroom.class,item);
		String description =(String)getExactProperty("description",Boardroom.class,item);
		
		Boardroom boardroom = new Boardroom(title, name, description);
		
		boardroom.setId(Integer.parseInt(item.getProperty("id").toString()));
		if(!checkIfObjectIsInList(boardroom,boardroomsTemp)){
			boardroomsTemp.add(boardroom);
		}
		return boardroom;
	}
	
	public static Panel parsePanel(SoapObject item) {

		String name = (String)getExactProperty("name",Panel.class,item);
		
		String description =(String)getExactProperty("description",Panel.class,item);
		
		Panel panel = new Panel(name, description);
		
		panel.setId(Integer.parseInt(item.getProperty("id").toString()));
		if(!checkIfObjectIsInList(panel,panelsTemp)){
			panelsTemp.add(panel);
		}
		return panel;
	}
	public static Speaker parseSpeaker(SoapObject item) {

		String name = (String)getExactProperty("name",Speaker.class,item);
		String lastName = (String)getExactProperty("lastName",Speaker.class,item);
		String description =(String)getExactProperty("description",Speaker.class,item);
		
		Speaker speaker = new Speaker(name, lastName, description);
		
		speaker.setId(Integer.parseInt(item.getProperty("id").toString()));
		if(!checkIfObjectIsInList(speaker,speakersTemp)){
			speakersTemp.add(speaker);
		}
		return speaker;
	}
	public static Presentation parsePresentation(SoapObject item) {

		String title = (String)getExactProperty("title",Presentation.class,item);
		Speaker speaker = (Speaker)getExactProperty("speaker",Presentation.class,item);
		String description =(String)getExactProperty("description",Presentation.class,item);
		
		Presentation presentation = new Presentation(title, description, speaker);
		
		presentation.setId(Integer.parseInt(item.getProperty("id").toString()));
		if(!checkIfObjectIsInList(presentation,presentationsTemp)){
			presentationsTemp.add(presentation);
		}
		return presentation;
		
	}
	public static Schedule parseSchedule(SoapObject item) {

		Date startDate = (Date)getExactProperty("startDate",Schedule.class,item);
		Date endDate =(Date)getExactProperty("endDate",Schedule.class,item); 		
		Conference conference =(Conference)getExactProperty("conference",Schedule.class,item); 	
		Boardroom boardroom =(Boardroom)getExactProperty("boardroom",Schedule.class,item);
		Panel panel =(Panel)getExactProperty("panel",Schedule.class,item);
		Presentation presentation=(Presentation)getExactProperty("presentation",Schedule.class,item);
		
		Schedule schedule = new Schedule(startDate, endDate, presentation, panel, conference, boardroom);
		
		schedule.setId(Integer.parseInt(item.getProperty("id").toString()));
		if(!checkIfObjectIsInList(schedule,schedulesTemp)){
			schedulesTemp.add(schedule);
		}
		return schedule;
	}

	public static Object getExactProperty(String fieldName,Class classType,SoapObject item){
		Object result =null;
		try {
			
			//TODO zabezpieczenie przed nulem !
			Field field =classType.getDeclaredField(fieldName);
			Class type = field.getType();
			
			if(type.equals(String.class)){
				result =item.getProperty(fieldName).toString();
			}else if(type.equals(Integer.class)||type.equals(Integer.TYPE)){
				result =Integer.parseInt(item.getProperty(fieldName).toString());
			}else if(type.equals(Date.class)){
				result =DateUtilities.getDateFromString(item.getProperty(
						fieldName).toString());
			}else if (type.isAssignableFrom(Conference.class)){
				SoapObject innerItem = (SoapObject)item.getProperty(fieldName); 
				int id = Integer.parseInt(innerItem.getProperty("id").toString());
				if((result=getObjectWithId(id, confernecesTemp))==null){
					result = EntityParser.parseConfernece(innerItem);
				}
			}else if (type.isAssignableFrom(Boardroom.class)){
				SoapObject innerItem = (SoapObject)item.getProperty(fieldName); 
				int id = Integer.parseInt(innerItem.getProperty("id").toString());
				if((result=getObjectWithId(id, boardroomsTemp))==null){
					result = EntityParser.parseBoardroom(innerItem);
				}
			}else if (type.isAssignableFrom(Panel.class)){
				SoapObject innerItem = (SoapObject)item.getProperty(fieldName); 
				int id = Integer.parseInt(innerItem.getProperty("id").toString());
				if((result=getObjectWithId(id, panelsTemp))==null){
					result = EntityParser.parsePanel(innerItem);
				}
			}else if (type.isAssignableFrom(Presentation.class)){
				SoapObject innerItem = (SoapObject)item.getProperty(fieldName); 
				int id = Integer.parseInt(innerItem.getProperty("id").toString());
				if((result=getObjectWithId(id, presentationsTemp))==null){
					result = EntityParser.parsePresentation(innerItem);
				}
			}else if (type.isAssignableFrom(Schedule.class)){
				SoapObject innerItem = (SoapObject)item.getProperty(fieldName); 
				int id = Integer.parseInt(innerItem.getProperty("id").toString());
				if((result=getObjectWithId(id, schedulesTemp))==null){
					result = EntityParser.parseSchedule(innerItem);
				}
			}else if (type.isAssignableFrom(Speaker.class)){
				SoapObject innerItem = (SoapObject)item.getProperty(fieldName); 
				int id = Integer.parseInt(innerItem.getProperty("id").toString());
				if((result=getObjectWithId(id, speakersTemp))==null){
					result = EntityParser.parseSpeaker(innerItem);
				}
			}
			
				
			
		} catch (SecurityException e) {
			e.printStackTrace();
		
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}		
		return result;
	}
}
