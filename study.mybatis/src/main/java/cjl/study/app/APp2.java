package cjl.study.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class APp2 {

	public static void main(String[] args) {
//		System.out.print("请输入数组的集合:");
//		Scanner in = new Scanner(System.in);
//		String numberList = in.next();
//		System.out.println("请输入组合的位数:");
//		Integer size = in.nextInt();
//		List<Integer> number = new ArrayList<>();
//		arrayToList(numberList.split(",")).forEach(a->number.add(Integer.parseInt(a)));
		List<Integer> number = new ArrayList<>();
		number.add(1);
		number.add(2);
		number.add(3);
		number.add(4);
		number.add(5);
		List<List<Integer>> a = groupList(number,2);
//		a.forEach(System.out::println);
		for(List<Integer> temp:a){
			System.out.println(temp);
		}
		System.out.println(a.size());
	}
	
	public static List<List<Integer>> groupList(List<Integer> number,Integer size){
		List<List<Integer>> result = new ArrayList<>();
		if(size == 1){
			number.forEach(temp->{
				List<Integer> list = new ArrayList<>();
				list.add(temp);
				result.add(list);
			});
			return result;
		}else if(size > 1){
			number.forEach(temp->{   
 				//复制原数据
				List<Integer> copy = new ArrayList<>(number);
				copy.remove(temp);
				List<List<Integer>> a = groupList(copy,size-1);
				a.forEach(b->{
					b.add(temp);
				});
				result.addAll(a);
			});
			return result;
		}else{
			return null;
		}
	}
	
	public static List<String> arrayToList(String ...is){
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(is));
		return list;
	}
	
	
	/**
	 * 递归获取组合数
	 * @param size
	 * @return
	 */
	public static int zuheshu(Integer size){
		if(size == 1){
			return 1;
		}else if(size > 0){
			return size*zuheshu(size-1);
		}else{
			throw new RuntimeException("组合位数不能小于0");
		}
	}
	
}


class A{
	
	public Object asd;
}

class B{
	
	public Object asd;
}
