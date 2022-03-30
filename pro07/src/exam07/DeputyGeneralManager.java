package exam07;

//차장
public class DeputyGeneralManager extends DepartmentManager{

	public DeputyGeneralManager(String name, int age) {
		super(name,age);
		setSalary(5500);
	}

	@Override
	public void bonus(int month) {
		switch(month) {
		case 4:	case 8:	case 12:
			super.bonus(month);
		}
	}
	
}
