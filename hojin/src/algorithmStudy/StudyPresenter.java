package algorithmStudy;

import java.util.Random;
import java.util.Scanner;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame() {
		
		super("발표자 랜덤 추출 프로그램 ver1.0");

		JPanel buttonPanel = new JPanel();
		
		JCheckBox check1 = new JCheckBox("호진");
        JCheckBox check2 = new JCheckBox("명진");
        JCheckBox check3 = new JCheckBox("형용");
        JCheckBox check4 = new JCheckBox("지훈");
        JCheckBox check5 = new JCheckBox("락현");
        JCheckBox check6 = new JCheckBox("민기");
        JCheckBox check7 = new JCheckBox("민호");
        
        buttonPanel.add(check1);
        buttonPanel.add(check2);
        buttonPanel.add(check3);
        buttonPanel.add(check4);
        buttonPanel.add(check5);
        buttonPanel.add(check6);
        buttonPanel.add(check7);
        
        JButton btn = new JButton("실행");
        buttonPanel.add(btn);
        
        add(buttonPanel);
        
		setSize(600, 400);
		setLayout(new FlowLayout());
        
		// 프로그램 생성되는 위치
		setLocation(150, 200);
		
		// X 버튼 누를시 프로그램도 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setVisible(true);
	}
}
	
public class StudyPresenter{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// MyFrame studyPresenterGUI = new MyFrame();
		
		Random random = new Random();
		
		Scanner scn = new Scanner(System.in);
		String[] nameList = scn.nextLine().split(" ");
		
		random.setSeed(System.currentTimeMillis());
		
		int num = random.nextInt(nameList.length);
		System.out.println(nameList[num]);
	}
}
