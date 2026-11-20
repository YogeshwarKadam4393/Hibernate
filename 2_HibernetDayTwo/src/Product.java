import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Product_Details")
public class Product {
	
	@Id
	private int pid;
	
	private String pname;

	private String paddress;
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + "]";
	}
	
	
	
	
}
