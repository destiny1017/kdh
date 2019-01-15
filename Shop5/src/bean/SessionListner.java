package bean;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListner implements HttpSessionListener {

	HttpSession session;
	
	HashMap<String, insertAddcart> map = new HashMap<>();
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {

// 세션 생성시 호출
		session = arg0.getSession();
		long time = session.getCreationTime();
		String id = session.getId();
		System.out.println(time + "에 생성된 세션" + id);
		
		insertAddcart addcart = new insertAddcart();
		addcart.start();		
		map.put(session.getId(), addcart);
		
	}

	@Override

	public void sessionDestroyed(HttpSessionEvent arg0) {

// 세션 만료시 호출
		
		HttpSession session = arg0.getSession();
		insertAddcart addcart = (insertAddcart) map.get(session.getId());
		addcart.stop();
		map.remove(session.getId());

		long time = session.getCreationTime();

		long last_time = session.getLastAccessedTime();
		long now_time = System.currentTimeMillis();
		String id = session.getId();
		ArrayList<AddCartDTO> list = (ArrayList<AddCartDTO>) session.getAttribute("list");
		if (list != null) {
			AddCartDAO cartDao = new AddCartDAO();
			for (int i = 0; i < list.size(); i++) {
				String uId = list.get(i).getuId();
				String pId = list.get(i).getpId();
				String size = list.get(i).getSize();
				String count2 = list.get(i).getCount();
				try {
					cartDao.insertInfo(uId, pId, size, count2);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		System.out.println((now_time - last_time) + "ms 만에 세션이 죽음" + id);

	}

	class insertAddcart extends Thread {
		
		@Override
		public void run() {
			HttpSession session2 = session;
			while (true) {

				try {
					Thread.sleep(600000);
					System.out.println("저장중...");
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ArrayList<AddCartDTO> list = (ArrayList<AddCartDTO>) session2.getAttribute("list");
				if (list != null) {
					AddCartDAO cartDao = new AddCartDAO();
					for (int i = 0; i < list.size(); i++) {
						String uId = list.get(i).getuId();
						String pId = list.get(i).getpId();
						String size = list.get(i).getSize();
						String count2 = list.get(i).getCount();
						try {
							cartDao.insertInfo(uId, pId, size, count2);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					session2.removeAttribute("list");
				}
			}
		}
	}

}
