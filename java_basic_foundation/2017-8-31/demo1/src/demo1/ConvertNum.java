package demo1;

import java.util.Scanner;

public class ConvertNum {
	
	public static String get(){
		// Money���ڴ������Ľ����
				long Money = 0;
				// String Mon[]={"��","Ҽ","��","��","��","��","½","��","��","��"};

				// int []arr={0,1,2,3,4,5,6,7,8,9};
				String[] arr1 = { "��", "һ", "��", "��", "��", "��", "��", "��", "��", "��" };
				String arr2[] = { "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ" }, je[] = new String[30];// je[]�������ڴ�����ֽ�ת���������
				
				// ҼǪ�򷡰�����ʰ������ ��Ǫ½����ʰ��
				// 12345 678
				StringBuilder sb=new StringBuilder();
				System.out.println("��������Ҫת���Ľ�");
				Scanner sc = new Scanner(System.in);
				Money = Long.parseLong(sc.next());
				// bitt���ڴ�ŵڼ�����ת���Ľ�����֣�
				int bitt = 0, j, k = -1, i = 0;
				// ת������
				while (Money != 0) {
					bitt = (int) (Money % 10L);
					// �����ÿ�����ֶ�Ӧ�Ĵ�дֵ
					for (j = 0; j < arr1.length; j++) {
						if (j == bitt)
							break;
					}
					// ����Ӧ��ֵ����je[]��
					if (k != -1) {
						je[i] = arr2[k];
						i++;
					}
					je[i] = arr1[j];
					i++;
					Money = Money / 10;
					k++;
					if (Money == 0) {
						// ���ת����Ľ��
						System.out.print("������Ľ��Ϊ��");
						i--;
						for (; i >= 0; i--)
							//System.out.print(je[i]);
							sb.append(je[i]);
					}
				}
				return sb.toString();
	}
	
	
	
	public static String regProcessor(String str){
		//String reg="(��[ʰ��Ǫ��ʰ��Ǫ��ʰ��Ǫ])+";//һ������
		String reg="(��[��ʰ��Ǫ])+";//һ������
		str=str.replaceAll(reg, "��");//������Ľ��Ϊ��һ������������
		String reg1="(��)+";
		str=str.replaceAll(reg1, "��");
		str=str.replaceAll("����", "��");
		str=str.replaceAll("����", "��");
		//1000007
		//������Ľ��Ϊ��һ�����������
		
		return str;
		
	}
	
	public static void main(String[] args) {
		//reg();
		//System.out.println(get());
		System.out.println(regProcessor(get())+"Ԫ");
	}

}
