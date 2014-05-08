package caem_prototype.main;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import caem_prototype.dao.EventDao;
import caem_prototype.dao.NotificationDao;
import caem_prototype.dao.PhotoDao;
import caem_prototype.dao.PlaceDao;
import caem_prototype.dao.RegistrationDao;
import caem_prototype.dao.TagDao;
import caem_prototype.dao.UserDao;
import caem_prototype.dao.UserLocationDao;
import caem_prototype.entity.Event;
import caem_prototype.entity.Notification;
import caem_prototype.entity.Photo;
import caem_prototype.entity.Place;
import caem_prototype.entity.Registration;
import caem_prototype.entity.Tag;
import caem_prototype.entity.User;
import caem_prototype.entity.UserLocation;
import caem_prototype.namingvalues.NamingValues;

public class HibernateMain {


	public static void main(String[] args) {

		createTestData();


	}

	public static void createTestData() {
		User user2 = new User();
		user2.setName("testname");
		user2.setPassword("q");
		user2.setRole(NamingValues.Role.Admin);
		user2.setSurname("Gur");
		user2.setUserName("admin");
		UserDao uDao = new UserDao();
		uDao.addUser(user2);

		Tag tag1 = new Tag();
		tag1.setTitle("newtag");
		TagDao tDao = new TagDao();
		tDao.addTag(tag1);

		Place place1 = new Place();
		place1.setAddress("new address");
		place1.setDescription("new description");
		place1.setName("place name");
		place1.setOpenHours("10.00 am");
		place1.setPhone("+903125555536");
		place1.setPosition("223,13113");
		Set<Tag> tags = new HashSet<>();
		tags.add(tag1);
		place1.setTags(tags);
		PlaceDao pDao = new PlaceDao();
		pDao.addPlace(place1);

		Photo photo1 = new Photo();
		photo1.setDiskUrl("C:/");
		photo1.setIsOwner(true);
		photo1.setPlace(place1);
		photo1.setUrl("www.photo.com/xsaaa");
		PhotoDao phDao = new PhotoDao();
		phDao.addPhoto(photo1);

		Notification not1 = new Notification();
		not1.setDescription("not description");
		not1.setTitle("not title");
		NotificationDao nDao = new NotificationDao();
		nDao.addNotification(not1);

		Event ev1 = new Event();
		ev1.setEventType(NamingValues.EventType.EventType1);
		ev1.setFinishTime(new Date());
		ev1.setIsRecurrent(true);
		ev1.setStartTime(new Date());
		ev1.setRecurrentUntil(new Date());
		ev1.setTags(tags);
		ev1.setTitle("Event Title");
		EventDao eDao = new EventDao();
		eDao.addEvent(ev1);

		UserLocation loc1 = new UserLocation();
		loc1.setPlace(place1);
		loc1.setTime(new Date());
		loc1.setUser(user2);
		UserLocationDao locDao = new UserLocationDao();
		locDao.addUserLocation(loc1);

		Registration r1 = new Registration();
		r1.setEvent(ev1);
		r1.setStatus("active");
		r1.setTimeOfRegistration(new Date());
		r1.setUser(user2);
		RegistrationDao rDao = new RegistrationDao();
		rDao.addRegistration(r1);

		rDao.listRegistrations();
		locDao.listUserLocations();




	}


}
