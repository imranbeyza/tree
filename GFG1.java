
package com.mycompany.gfg1;

import java.util.*;

class GFG1{

    private static Object secenek;

static class Node
{
	int key;
	Node left, right;
}
static Node newNode(int item)
{
	Node temp = new Node();
	temp.key = item;
	temp.left = temp.right = null;
	return temp;
}

static void inorder(Node root)
{
	if (root != null)
	{
		inorder(root.left);
		System.out.print(root.key + " ");
		inorder(root.right);
	}
}
static Node insert(Node node, int key)
{
	if (node == null)
		return newNode(key);

	if (key < node.key)
		node.left = insert(node.left, key);
	else
		node.right = insert(node.right, key);

	return node;
}

static Node deleteNode(Node root, int k)
{
	if (root == null)
		return root;
	if (root.key > k)
	{
		root.left = deleteNode(root.left, k);
		return root;
	}
	else if (root.key < k)
	{
		root.right = deleteNode(root.right, k);
		return root;
	}
	if (root.left == null)
	{
		Node temp = root.right;
		return temp;
	}
	else if (root.right == null)
	{
		Node temp = root.left;
		return temp;
	}

	else
	{
		Node succParent = root;

		Node succ = root.right;
		
		while (succ.left != null)
		{
			succParent = succ;
			succ = succ.left;
		}

		if (succParent != root)
			succParent.left = succ.right;
		else
			succParent.right = succ.right;

		root.key = succ.key;

		return root;
	}
}
public static void main(String args[])
{
	Node root = null;
        Scanner scanner = new Scanner(System.in);
        int n,y;
        while(true){
         System.out.println("\n1.root ekleme");
         System.out.println("2.ekleme");
         System.out.println("3.silme");
         System.out.println("4.yazdirma");
         String s = scanner.nextLine();
  
         switch (s) {
            case"1":
                System.out.println("Root degeri giriniz");
                n = scanner.nextInt();
                root = insert(root, n);
                break;
            case "2":
                System.out.println("Eklemek istediğiniz degeri giriniz");
                n = scanner.nextInt();
                root = insert(root, n);
                break;
            case "3":
                System.out.println("Silmek istedginiz değeri giriniz");
                n = scanner.nextInt();
                root = deleteNode(root, n);
                break;
            case "4":
                System.out.println("yazdir");
               	inorder(root);
                break;
           
        }
        }
}
}

