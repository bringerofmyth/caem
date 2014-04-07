package caem_prototype.namingvalues;

public class NamingValues {

	public enum Role{
		Admin,
		EventOwner,
		Attender;
		
		@Override
		  public String toString() {
		    switch(this) {
		      case Admin: return "Admin";
		      case EventOwner: return "Event Owner";
		      case Attender: return "Attender";
		      default: throw new IllegalArgumentException();
		    }
		
	}
	}
}
