package com.wh.observer.JavaSupport;

import java.util.Observable;
import java.util.Observer;

public class Watcher implements Observer {

	private String name;

	private Watched watched;

	public Watched getWatched() {
		return watched;
	}

	public Watcher(Watched watched) {
		super();
		this.watched = watched;
	}

	public void setWatched(Watched watched) {
		this.watched = watched;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Watcher(String name) {
		this.name = name;
	}

	/*
	 * public Watcher(String name,Watched o) { this.name = name;
	 * o.addObserver(this); }
	 */

	@Override
	public void update(Observable obs, Object obj) {
		// System.out.println(observable);
		System.out.println(this.getName() + " recevied from " + ((Watched) obs).getName() + "ÔÚ"
				+ ((Watched) obs).getData() + "»éÀñÑûÇë¡£");

	}

}
