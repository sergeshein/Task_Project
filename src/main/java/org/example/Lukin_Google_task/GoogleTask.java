package org.example.Lukin_Google_task;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GoogleTask {
    String decodeStr(String s){
        Map<Integer, Integer>brackets = new HashMap<>();
        Stack<Integer>openBrackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '['){
                openBrackets.push(i);
            }
            if(s.charAt(i) == ']'){
              int openBracket = openBrackets.pop();
              brackets.put(openBracket, i);
            }
        }
        return decode(s, 0, s.length() -1, brackets);
    }
    String decode(String s, // Содержимое скобки передаем в виде всей исходной строки
                  int l, int r, // Границы скобки
                  Map<Integer, Integer>brackets){  // Ключи это позиция откр. скобок. Значения это позиция закрывающихся скобок
        int k = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = l; l < r; i++){ // идем по каждому символу скобки в цикле от l до r
            char cur = s.charAt(i);
            if(Character.isLetter(cur)){ //если это буква
                answer.append(cur); // то добавляем ее в конец нашего ответа
            } else if (Character.isDigit(cur)) {// если это цифра, то пишем ее в К
                k = k * 10 + k - '0';//в случае если две цифры подряд... из чара приводим в инт
            } else if (cur == '[') { //вызываем рекурсию
                int rb = brackets.get(i);// берем по индексу i позицию открывающейся скобки, позицию закрывающейся
                String bracket = decode(s, i + 1, rb - 1, brackets);
                answer.append(bracket.repeat(k)); // в итоговый ответ добавляем результат расшифровки скобки, повторенный к раз
                k = 0; // сбрасывем значение переменной
                i = rb; // продолжаем обход строки с символа после закрывающейся скобки
                
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        GoogleTask googleTask = new GoogleTask();
        try {
            googleTask.decodeStr("3[as]2[ww])");
        }catch (StringIndexOutOfBoundsException e){
            e.printStackTrace();;
        }


    }
}
