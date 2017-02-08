/*
�������ģʽ���ѿɱ����Ϊ��ȡ�������γ�һ���㷨�أ��������������ǵ�Ӧ�ø����ڱ仯��

	���޸Ĺرգ�����չ���š�
*/

interface CatchMouseable{
	void catchMouse(String name);
}
//
class CatchMouseableImpl1 implements CatchMouseable{
	public void catchMouse(String name){
		System.out.println("����" + name + ",����ץ���󡣡���������");
	}
}
class CatchMouseableImpl2 implements CatchMouseable{
	public void catchMouse(String name){
		System.out.println("����" + name + ",��ֻ���㣬����˭�ҵ�è��������...");
	}
}


abstract class Cat{
	private String name;
	private CatchMouseable cm;
	
	public void setCM(CatchMouseable cm){
		this.cm = cm;
	}

	public Cat(String name){
		this.name = name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void catchMouse(){
		cm.catchMouse(name);
		//System.out.println("ץ����.....");
	}
}

class BaiCat extends Cat{
	
	public BaiCat(String name){
		super(name);
	}
	/*
	public void catchMouse(){
		System.out.println("����" + getName() + "������ץ����");
	}
	*/
}

class HeiCat extends Cat{
	public HeiCat(String name){
		super(name);
	}
	/*
	public void catchMouse(){
		System.out.println("����" + getName() + ",��ֻ���㣬�Ҳ���ץ���󡣡�����");
	}
	*/
}


class CeLueDemo {
	public static void main(String[] args) {
		BaiCat bc = new BaiCat("��è");
		bc.setCM(new CatchMouseableImpl1());
		bc.catchMouse();

		HeiCat hc = new HeiCat("��è");
		hc.setCM(new CatchMouseableImpl1());
		hc.catchMouse();
	}
}
