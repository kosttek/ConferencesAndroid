package pl.edu.kosttek;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pl.edu.kosttek.entity.Boardroom;
import pl.edu.kosttek.entity.Conference;
import pl.edu.kosttek.entity.Panel;
import pl.edu.kosttek.entity.Presentation;
import pl.edu.kosttek.entity.Schedule;
import pl.edu.kosttek.entity.Speaker;
import android.app.Application;



public class ConferencesAndroid extends Application{
	static private List <Conference> conferneces = new ArrayList<Conference>();
	static private List <Boardroom> boardrooms = new ArrayList<Boardroom>();
	static private List <Panel> panels = new ArrayList<Panel>();
	static private List <Presentation> presentations = new ArrayList<Presentation>();
	static private List <Schedule> schedules = new ArrayList<Schedule>();
	static private List <Speaker> speakers = new ArrayList<Speaker>();

	static public List <Conference> getConferneces() {
		return conferneces;
	}

	static public void setConferneces(List <Conference> confernecesSet) {
		ConferencesAndroid.conferneces = confernecesSet;
	}

	public static List <Boardroom> getBoardrooms() {
		return boardrooms;
	}

	public static void setBoardrooms(List <Boardroom> boardrooms) {
		ConferencesAndroid.boardrooms = boardrooms;
	}

	public static List <Panel> getPanels() {
		return panels;
	}

	public static void setPanels(List <Panel> panelsFromData) {
		ConferencesAndroid.panels = panelsFromData;
	}
	public static List <Panel> getPanelsByConferneceId(int id){
		Set <Panel> panelSet = new HashSet<Panel>();
		for(Schedule sch : schedules){
			if(sch.getConference().getId()==id){
				panelSet.add(sch.getPanel());
			}
		}
		List <Panel> resultList = new ArrayList<Panel>(panelSet);
		return resultList;
	}
	public static Panel getPanelById(int id){
		for(Panel pan : panels){
			if(pan.getId()==id){
				return pan;
			}
		}
		return null;
	}

	public static List <Presentation> getPresentations() {
		return presentations;
	}

	public static void setPresentations(List <Presentation> presentations) {
		ConferencesAndroid.presentations = presentations;
	}

	public static List <Schedule> getSchedules() {
		return schedules;
	}
	public static List <Schedule> getSchedulesByConferneceId(int id) {
		List <Schedule> list = new ArrayList<Schedule>();
		for(Schedule sch : schedules){
			if(sch.getConference().getId()==id){
				list.add(sch);
			}
		}
		return list;
	}

	public static void setSchedules(List <Schedule> schedules) {
		ConferencesAndroid.schedules = schedules;
	}

	public static List <Speaker> getSpeakers() {
		return speakers;
	}

	public static void setSpeakers(List <Speaker> speakers) {
		ConferencesAndroid.speakers = speakers;
	}
	

}
