import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class TestFrame {
	IMActionManager actionManager = new IMActionManager();
	
	public static void main(String[] args) {
		TestFrame test = new TestFrame();
		JFrame f = new JFrame("Test Actions");
		f.setSize(100, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setLayout(new FlowLayout());
		test.add(f);
		f.validate();
	}
	
	public void add(JFrame f) {
		JButton b = new JButton("b2221");
		b.setHideActionText(true);
		b.setAction(actionManager.getActionMap(this).get("test"));
		f.add(b);
		
		f.add(new MyButton());
	}
	
	@IMActionHandler(name="test")
	public void test() {
		System.out.println("ok");
	}
	
	@IMActionHandler(name="test")
	public void test2() {
		System.out.println("ok22");
	}
	
	class MyButton extends JButton {
		public MyButton() {
			setAction(actionManager.getActionMap(TestFrame.this).get("test"));
			setHideActionText(true);
			setText("b22");
		}
	}
}
