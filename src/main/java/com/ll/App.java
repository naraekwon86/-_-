package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner;
    int lastQuotationId;
    List<Quotation> quotations;

    App(){

        scanner = new Scanner(System.in);
        lastQuotationId = 0;
        quotations = new ArrayList<>();
    }

    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite();

            } else if (cmd.equals("목록")) {
                actionList();
            } else if(cmd.startsWith("삭제?")){
                actionRemove(cmd);
            } else if (cmd.startsWith("수정?")) {
                actionModify(cmd);
            }
        }
        void actionWrite () {
            System.out.println("명언 : ");
            String Content = scanner.nextLine();

            System.out.println("작가 : ");
            String authorName = scanner.nextLine();

            System.out.printf("명언 : %s , 작가 : %s\n", Content, authorName);

            lastQuotationId++;
            int id = lastQuotationId;
            Quotation quotation = new Quotation(lastQuotationId, Content, authorName);
            quotation.add(quotation);
            System.out.printf("%d번 명언이 등록 되었습니다.\n", lastQuotationId);
        }
        void actionList () {
            System.out.println("번호 / 작가 / 명언");
            System.out.println("----------------------------");
            if (quotations.isEmpty())
                System.out.println("등록된 명언이 없습니다");

            Quotation quotation;
        }

        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);
            System.out.printtf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }

        void actionRemove(String cmd){
            int id = getParamAsInt(cmd , "id" , 0);
                if ( id == 0){
                    System.out.println("id를 입력해 주세요.");
                    return; //함수를 끝낸다

                }
        }
        void actionModify(String cmd){
            int id = getParamAsInt(cmd , "id" , 0);

        }

        int getParamAsInt(String cmd , String paramName , int defaultValue){
            String[] cmdBits = cmd.split("\\?", 2);
//          String action = cmdBits[0]; 이제 액션은 필요가 없다
            String queryStringBits = cmdBits[1];

            String[] queryStringBits = queryStringBits.split("&");

//            int id = 0; 이제 id가 아니다

            for (int i = 0; i < queryStringBits.length; i++) {
                String queryParamStr = queryStringBits[i];
                String[] queryStringBits = queryParamStr.split("=", 2);

                String _ParamName = queryStringBits[0];
                String ParamValue = queryStringBits[1];

                if (_paramName.equals(paramName)) {
                    try {
                        return integer.parseInt(ParamValue);
                    } catch (NumberFormatException e) {
                        return defaultValue;

                    }

                }
            }
                return defaultValue;
        }
    }
}