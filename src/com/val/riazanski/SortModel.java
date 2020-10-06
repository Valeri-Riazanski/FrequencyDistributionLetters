package com.val.riazanski;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortModel {
    public static void getFrequencyDistribution(String text){
        text = text.toLowerCase();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            // ё идёт отдельно от а-я
            if((ch >= 'а' && ch <= 'я') || ch == 'ё'){
                map.merge(ch,1,Integer::sum);
            }
        }
        // несортированный лист
        ArrayList<HashMap.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        System.out.println("несортированный лист ");
        for(Map.Entry<Character, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        //лист сортированный по буквам
        entries.sort((o1, o2) -> Character.compare(o1.getKey(), o2.getKey()));
        System.out.println("лист сортированный по буквам ");
        for(Map.Entry<Character, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        //лист сортированный по частоте
        entries.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        System.out.println("лист сортированный по частоте ");
        for(Map.Entry<Character, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        //поменяли местами ключ значение
        HashMap<Integer,Character> swap = new HashMap<>();
        for (int i = 0; i < entries.size(); i++) {
            //Character character = entries.get(i).getKey();
            swap.put(entries.get(i).getValue(),entries.get(i).getKey());
        }
        System.out.println("поменяли местами ключ значение ");
        swap.forEach((k,v) -> System.out.println(k + " " + v));
        System.out.println("почему пар стало меньше?" + '\n' + "наверное, потому что ключ должен быть уникальным ");
    }
    public static void main(String[] args) {
        String str = "цдлуатцджула'lwkf'qlwrklfq'lfrэудкфдцулатйдцула дцул цудлкй.цудлкдлаоэдукпоэукпо34-05-14-85" +
                "т.йцдулжат.йдцулат.йдцулат.йц'w;elf';wefjw';efj'w;elfjwe;f";
        getFrequencyDistribution(str);
    }
}
