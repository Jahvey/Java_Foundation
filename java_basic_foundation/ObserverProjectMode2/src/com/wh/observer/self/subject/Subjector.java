package com.wh.observer.self.subject;

import java.util.List;

import com.wh.observer.self.object.Observor;
//���۲��ߣ�����
public interface Subjector {
	// this
	public void attach(Observor o);

	public void attachs(List<Observor> listObject);

	public boolean delobj(Observor o);

	public boolean delobjs(List<Observor> listObject);

	public boolean notifyObject(String msg);
	


}
