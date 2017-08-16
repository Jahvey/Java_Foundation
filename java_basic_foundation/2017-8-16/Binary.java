/***
result
javac Binary.java -encoding utf-8

java Binary
a
b
c

C:\Users\Administrator\Desktop>

二叉树除了可以保存数据之外，还可以对数据进行排序

但是不管是何种操作，都是node的节点的操作，都是
数据的保存形式不同而已。
*/


public class Binary{
	
	public static void main(String args[]){
		
		//System.out.println("hello");
		BinaryTree bt=new BinaryTree();
		bt.add("b");
		bt.add("c");
		bt.add("a");
		bt.print();
		
	}
}


class BinaryTree{
	//简单的二叉树的示例代码
	private Node root;//根节点
	
	public  void add(String data){
		Node newNode=new Node(data);//数据都要封装成为节点
		if(this.root==null){//根节点为空
			this.root=newNode;//第一个节点为根节点
		}else{
			//应该交给node类保存在合适的位置上面(左，右)
			this.root.addNode(newNode);
	
		}
		
	}
	
	public  void print(){
		if(this.root!=null){
			this.root.printNode();
		}
	}
	
	
}

class Node{
	
	private String data;
	public Node left;
	public Node right;
	public Node(String data){
		this.data=data;
	}
	public String getData(){
		return this.data;
	}
	
	public void setLeft(Node left){
			this.left=left;
	}
	public Node getLeft(){
		return this.left;
	}
	public void setRight(Node right){
		this.right=right;
	}
	public Node getRight(){
		return this.right;
	}
	

	public void printNode(){
		if(this.left!=null){//有左子树
		
			this.left.printNode();
		
		}
		System.out.println(this.data);
		if(this.right!=null){//有右子树
			this.right.printNode();
		}
	}
	
	
	public void addNode(Node newNode){
		//添加节点
		if(newNode.getData().compareTo(this.data)<0){//小于0
			if(this.left==null){//left节点没有内容
			this.left=newNode;//保存左子树
		}else{
			this.left.addNode(newNode);//递归调用，谁用谁知道
			//向下继续保存
			
		}
			
			
		}else{//如果要添加的结点的内容大于要比较的data
			
			if(this.right==null){
				this.right=newNode;
				
			}else{
				//保存在右子树中
				this.right.addNode(newNode);
			}
			
		}
	}
	
	
}