package com.amazon.ds;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	class Node {
	     Map<Character,Node> next ;
	     boolean endFlag;
	     
	     public Node() {
	    	 next= new HashMap<Character,Node>();
	    	 endFlag=false;
	     }
	     
	}
	

	public void insert(String word,Node root) {		
		Node current=root;
		
		for (int i=0;i<word.length();i++) {
			Character _char=word.charAt(i);
			if (!current.next.containsKey(_char)) {
				Node temp=new Node();
				current.next.put(_char, temp);
			}
			current=current.next.get(_char);
		}	
		current.endFlag=true;
		
		root=current;
	}
	
	public boolean contains(String word,Node root) {		
		Node current=root;
		
		for (int i=0;i<word.length();i++) {
			Character _char=word.charAt(i);
			if (current.endFlag)
				return false;
			
			if (current.next.containsKey(_char)) {
				current=current.next.get(_char);
			}else
				return false;
			
		}	
		
		return true;
	}
	
	
	public static void main(String[] args) {
		Trie _try=new Trie();
		Node root=_try.new Node();
		_try.insert("abc",root);
		_try.insert("abcd",root);
		_try.insert("azt",root);
		System.out.println("contains:"+_try.contains("", root));		
	}

}
