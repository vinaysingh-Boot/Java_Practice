package com.practice;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Vector;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		
		String str = "adfreghgfi";
		
		List<String> asList = Arrays.asList("vinay","vinay singh","chandan","Chandan Singh");
		
		// remove vowels from a string
		String collect = str.chars().filter(ch -> !"aeiouAEIOU".contains( String.valueOf((char)ch))).mapToObj(ch ->String.valueOf((char) ch))
		.collect(Collectors.joining());
		System.out.println(collect);
		
		/* convert a string into upper case*/
		Optional<String> optionalString = Optional.of(str);
		
		String collect2 = optionalString.map(String :: toUpperCase).orElse("");
		System.out.println(collect2);
		
		/* Convert a List of String into upper case*/
		
		List<String> collect3 = asList.stream().map(String :: toUpperCase).collect(Collectors.toList());
		System.out.println(collect3);
		
		// count frequency of words;
		
		String str2 = "vinay vinay manoj chandan manoj vinay";
		
		Map<String, Long> collect4 = Arrays.asList(str2.split(" ")).stream().
				collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println(collect4);
		
		// occurance of character
		
		Map<Character, Long> collect5 = str2.chars().mapToObj(ch -> (char) ch).
				collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		System.out.println(collect5);
		
		// Length of String
		
		String str3 = "vinay kumar singh chandan manoj";
		
		Map<String, Integer> collect6 = Arrays.stream(str3.split(" ")).collect(Collectors.toMap(word-> word, word->word.length()));
		System.out.println(collect6);
		
		long count = str3.chars().count();
		System.out.println(count);
		
		// first non repeating character 
		
		str3 = "sdasdsc";
		
		Optional<Entry<Character,Long>> first = str3.chars().mapToObj( ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,Collectors.counting()))
		.entrySet().stream().filter(entry -> entry.getValue()==1).findFirst();
		
		System.out.println(first);
		
		System.out.println("\n *****************************************************************************************");
		
		Vector<String> names = new Vector<>();
		names.add("Vinay");
		names.add("Chandan");
		names.add("Shubham");
		names.add("Ansh");
		
		Enumeration<String> e = names.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		System.out.println("\n *****************************************************************************************");
		
		
		Iterator<String> i = names.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		System.out.println("\n *****************************************************************************************");
		
		List<String> listOfName = Arrays.asList("Vinay Singh","Shubham Kumar Singh","Chandan");
		
		ListIterator<String> listItr = listOfName.listIterator();
		while(listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		
		System.out.println("\n *********************************Using For Each********************************************************");
		
		listOfName.stream().forEachOrdered(t -> System.out.println(t) );
		
	}

}
