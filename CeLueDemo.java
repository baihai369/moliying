/*
策略设计模式：把可变的行为抽取出来，形成一个算法簇，这样可以让我们的应用更利于变化。

	对修改关闭，对扩展开放。
*/

interface CatchMouseable{
	void catchMouse(String name);
}
//
class CatchMouseableImpl1 implements CatchMouseable{
	public void catchMouse(String name){
		System.out.println("我是" + name + ",我能抓老鼠。。。。。。");
	}
}
class CatchMouseableImpl2 implements CatchMouseable{
	public void catchMouse(String name){
		System.out.println("我是" + name + ",我只吃鱼，现在谁家的猫还管老鼠啊...");
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
		//System.out.println("抓老鼠.....");
	}
}

class BaiCat extends Cat{
	
	public BaiCat(String name){
		super(name);
	}
	/*
	public void catchMouse(){
		System.out.println("我是" + getName() + "，我能抓老鼠！");
	}
	*/
}

class HeiCat extends Cat{
	public HeiCat(String name){
		super(name);
	}
	/*
	public void catchMouse(){
		System.out.println("我是" + getName() + ",我只吃鱼，我不能抓老鼠。。。。");
	}
	*/
}


class CeLueDemo {
	public static void main(String[] args) {
		BaiCat bc = new BaiCat("白猫");
		bc.setCM(new CatchMouseableImpl1());
		bc.catchMouse();

		HeiCat hc = new HeiCat("黑猫");
		hc.setCM(new CatchMouseableImpl1());
		hc.catchMouse();
	}
}
