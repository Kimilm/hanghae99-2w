package kimilm;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solutions {
    // https://programmers.co.kr/learn/courses/30/lessons/12901
    public String _2016년(int a, int b) {
        // 인덱스 관리를 쉽게 하기 위해 0월은 0일 추가
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 16년 1월 1일이 금요일 -> 0일은 목요일
        String[] week = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        // 날짜 더하기, 2월 3일 == 1월 34일 == 수요일
        int days = b;
        for (int i = 0; i < a; ++i) {
            days += month[i];
        }

        days %= 7;

        return week[days];
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12910
    public int[] 나누어_떨어지는_숫자_배열(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        // divisor로 나누어 떨어지는 값만 리스트에 저장
        for (int num : arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        // 아무것도 저장하지 못했다면 -1 추가
        if (list.size() == 0) {
            list.add(-1);
        }
        // 정렬
        Collections.sort(list);
        // 배열로 변환
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12922
    public String 수박수박수박수박수박수(int n) {
        // "수", "박"을 미리 선언
        String[] watermelon = new String[]{"수", "박"};
        StringBuilder sb = new StringBuilder();
        //짝수라면 수, 홀수라면 박 n 길이만큼 연결
        for (int i = 0; i < n; i++) {
            sb.append(watermelon[i % 2]);
        }
        // 스트링으로 리턴
        return sb.toString();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42576
    public String 완주하지_못한_선수(String[] participant, String[] completion) {
        // 선수들 정보를 담을 해시맵 선언
        Map<String, Integer> marathon = new HashMap<>();
        // 참여자들을 해시맵에 저장, 동명이인 처리
        for (String person : participant) {
            marathon.put(person, marathon.getOrDefault(person, 0) + 1);
        }
        // 완주자들 처리
        for (String person : completion) {
            marathon.put(person, marathon.get(person) - 1);
        }

        String answer = "";
        // 완주하지 못한 사람을 발견하면 정답 변수에 저장
        for (Map.Entry<String, Integer> entry : marathon.entrySet()) {
            if (entry.getValue() == 1) {
                answer = entry.getKey();
                break;
            }
        }
        // 리턴
        return answer;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12931
    public int 자릿수_더하기(int n) {
        // 숫자를 문자열로 변환
        String str = String.valueOf(n);
        // 문자열을 하나하나 쪼개서 숫자로 바꾸고 더함
        return Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12930
    public String 이상한_문자_만들기(String s) {
        // 공백이 두개면 두개를 남겨야 함
        // 모든 문자를 대문자로 변환하고 문자 배열로 변경
        char[] chars = s.toUpperCase().toCharArray();

        int flag = 0;
        for (int i = 0; i < chars.length; i++) {
            // 공백이라면 단어 인덱스용 flag 변수 초기화
            if (chars[i] == ' ') {
                flag = 0;
                continue;
            }
            // 공백이 아니라면 짝수 인덱스를 소문자로 변환
            if (flag % 2 == 1) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
            // 단어 인덱스 증가
            ++flag;
        }
        // 문자열로 변환하여 리턴
        return new String(chars);
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12932
    public int[] 자연수_뒤집어_배열로_만들기(long n) {
        // 자연수를 문자열로 변환
        String str = String.valueOf(n);
        // 문자열을 뒤집어서 저장
        StringBuilder sb = new StringBuilder(str).reverse();
        // 뒤집힌 문자열의 각 문자를 숫자로 바꿔서 배열로 변환
        return sb.chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12933
    public long 정수_내림차순으로_배치하기(long n) {
        // 숫자 -> 문자열 -> 문자로 변환
        String str = String.valueOf(n).chars()
                // 문자를 숫자로 변환
                .map(Character::getNumericValue)
                // 내림차순 정렬을 위해 Integer로 변환
                .boxed()
                // 내림차순 정렬
                .sorted(Collections.reverseOrder())
                // 숫자를 합치기 위해 문자로 변환
                .map(String::valueOf)
                // 문자열로 합치기
                .collect(Collectors.joining());
        // long 값으로 변환하여 리턴
        return Long.parseLong(str);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12935
    public int[] 제일_작은_수_제거하기(int[] arr) {
        // 배열을 추가 제거가 용이한 리스트로 변환
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        // 최솟값 찾기
        Integer min = Collections.min(list);
        // 최솟값 제거
        list.remove(min);
        // 리스트의 길이가 0이라면 -1 추가
        if (list.size() == 0) {
            list.add(-1);
        }
        // 배열로 바꿔서 리턴
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12934
    public long 정수_제곱근_판별(long n) {
        // 제곱근 구하기 (소숫점 버림)
        long sqrt = (long) Math.sqrt(n);
        // 제곱근의 제곱 구하기 (소숫점 버림)
        long pow = (long) Math.pow(sqrt, 2);
        // 제곱수가 아니라면 -1 리턴
        if (pow != n) {
            return -1;
        }
        // 제곱수라면 제곱근 + 1을 제곱하여 리턴
        return (long) Math.pow(sqrt + 1, 2);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12943
    public int 콜라즈_추측(int num) {
        // 오버플로우 대비 long으로 변환
        long longNum = num;
        // 횟수 저장용 변수
        int count = 0;
        // 500이 넘지 않았을 때
        while (count < 500) {
            // 1이 되었다면 횟수 리턴
            if (longNum == 1) {
                return count;
            }
            // 짝수라면 2로 나누기
            if (longNum % 2 == 0) {
                longNum /= 2;
            }
            // 홀수라면 3 곱하고 1 더하기
            else {
                longNum = longNum * 3 + 1;
            }
            // 카운트 증가
            ++count;
        }
        // 500번이 넘었다면 -1 리턴
        return -1;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12947
    public boolean 하샤드_수(int x) {
        // 아까 만든 자릿수 더하기 사용
        int sum = 자릿수_더하기(x);
        // 나누어지면 true, 아니면 false 리턴
        return x % sum == 0;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/86491
    public int 최소_직사각형(int[][] sizes) {
        // 명함 개수
        int n = sizes.length;
        // 명함 가로 세로를 긴쪽 짧은쪽으로 바꾸기
        for (int i = 0; i < n; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        // 긴쪽과 짧은쪽을 따로 분리해서 저장
        int[] idCardLong = new int[n];
        int[] idCardShort = new int[n];
        for (int i = 0; i < n; i++) {
            idCardLong[i] = sizes[i][0];
            idCardShort[i] = sizes[i][1];
        }
        // 정렬
        Arrays.sort(idCardLong);
        Arrays.sort(idCardShort);
        // 최댓값 곱해서 리턴
        return idCardLong[n - 1] * idCardShort[n - 1];
    }

    // https://programmers.co.kr/learn/courses/30/lessons/68935
    public int 삼진법_뒤집기(int n) {
        // 10진법 숫자 -> 3진법 문자열로 변환하기
        String num = Integer.toString(n, 3);
        // 뒤집기
        num = new StringBuilder(num).reverse().toString();
        // 3진법 문자열 -> 10진법 숫자로 변환하여 리턴
        return Integer.parseInt(num, 3);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12906
    public int[] 같은_숫자는_싫어(int[] arr) {
        // 큐 선언
        LinkedList<Integer> queue = new LinkedList<>();
        // 배열의 원소만큼 반복하면서
        for (int element : arr) {
            // 큐의 맨 끝 원소와 다르다면 입력
            if (queue.isEmpty() || queue.getLast() != element) {
                queue.add(element);
            }
        }
        // 리스트를 배열로 변환하여 리턴
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/68644
    public int[] 두_개_뽑아서_더하기(int[] numbers) {
        // 값을 저장할 집합 선언
        Set<Integer> set = new HashSet<>();
        // 모든 경우의 수
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                // 더해서 집합에 저장
                set.add(numbers[i] + numbers[j]);
            }
        }
        // 집합을 배열로 변경하고 정렬하여 리턴
        return set.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42840
    public int[] 모의고사(int[] answers) {
        // 수포자 리스트 생성
        List<NoMath> students = new ArrayList<>();
        // 각자 찍는 방식대로 초기화
        students.add(new NoMath(new int[]{1, 2, 3, 4, 5}, 1));
        students.add(new NoMath(new int[]{2, 1, 2, 3, 2, 4, 2, 5}, 2));
        students.add(new NoMath(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, 3));
        // 가장 많이 맞춘 학생 점수
        int topScore = 0;
        // 성적 산출
        for (NoMath student : students) {
            student.marking(answers);
            topScore = Integer.max(topScore, student.getScore());
        }
        // 정답용 학생 번호 리스트
        List<Integer> answer = new ArrayList<>();
        // 가장 많이 맞춘 학생들만 남기기
        for (NoMath student : students) {
            if (student.getScore() == topScore) {
                answer.add(student.getStudentNum());
            }
        }
        // 학생번호 배열로 바꿔서 리턴
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    class NoMath {
        private int[] fork;
        private int studentNum;
        private int score;

        // 생성자
        public NoMath(int[] fork, int studentNum) {
            this.fork = fork;
            this.studentNum = studentNum;
            this.score = 0;
        }

        // 성적 산출 함수
        public void marking(int[] answers) {
            // fork 배열에서 사용될 인덱스
            int index = 0;
            // 채점
            for (int i = 0; i < answers.length; i++) {
                // 답이 맞았으면 score 증가
                if (answers[i] == fork[index]) {
                    ++score;
                }
                // fork 배열 인덱스 조정
                index = (index + 1) % fork.length;
            }
        }

        // 학생 번호
        public int getStudentNum() {
            return studentNum;
        }

        // 성적
        public int getScore() {
            return score;
        }
    }

    // https://programmers.co.kr/learn/courses/30/lessons/77484
    public int[] 로또의_최고_순위와_최저_순위(int[] lottos, int[] win_nums) {
        // 당첨 등수 저장
        int[] prize = {6, 6, 5, 4, 3, 2, 1};
        // 당첨 번호 저장용 Set 선언
        Set<Integer> lottoSet = new HashSet<>();
        // 당첨번호 저장
        for (int num : win_nums) {
            lottoSet.add(num);
        }
        // 낙서된 숫자 저장 변수
        int signed = 0;
        // 맞춘 번호 체크
        for (int num : lottos) {
            if (num == 0) {
                // 낙서된 번호는 체크
                ++signed;
            } else {
                // 맞춘 번호는 제거
                lottoSet.remove(num);
            }
        }
        // 6개 - 남은 당첨 번호 개수 == 내가 맞춘 번호 개수
        int correct = 6 - lottoSet.size();
        // 내가 맞춘 번호 개수 + 낙서된 번호 == 최고 순위, 내가 맞춘 번호 개수 == 최저 순위
        return new int[]{prize[signed + correct], prize[correct]};
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12915
    public String[] 문자열_내_마음대로_정렬하기(String[] strings, int n) {
        // 내맘대로 정렬
        Arrays.sort(strings, (s1, s2) -> {
            // n번 인덱스 값을 비교
            int compare = s1.charAt(n) - s2.charAt(n);
            // 같으면 사전순
            if (compare == 0) {
                return s1.compareTo(s2);
            }
            // 다르면 오름차순
            return compare;
        });
        //리턴
        return strings;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12917
    public String 문자열_내림차순으로_배치하기(String s) {
        // char 배열로 변경
        char[] array = s.toCharArray();
        // char 순으로 정렬
        Arrays.sort(array);
        // 뒤집기
        int n = s.length();
        char[] reverse = new char[n];
        for (int i = 0, j = n - 1; i < n; i++, --j) {
            reverse[i] = array[j];
        }
        // 문자열로 바꿔서 리턴
        return new String(reverse);
        // 스트링 빌더로 뒤집으면 되는구나....
    }

    // https://programmers.co.kr/learn/courses/30/lessons/81301
    public int 숫자_문자열과_영단어(String s) {
        // 변경할 단어 저장
        // 배열에 담아도 똑같구나..q;
        Map<String, String> wordMap = new HashMap<>();
        wordMap.put("zero", "0");
        wordMap.put("one", "1");
        wordMap.put("two", "2");
        wordMap.put("three", "3");
        wordMap.put("four", "4");
        wordMap.put("five", "5");
        wordMap.put("six", "6");
        wordMap.put("seven", "7");
        wordMap.put("eight", "8");
        wordMap.put("nine", "9");
        // 순회하며 변경
        for (Map.Entry<String, String> entry : wordMap.entrySet()) {
            s = s.replaceAll(entry.getKey(), entry.getValue());
        }
        // 숫자로 바꿔서 리턴
        return Integer.parseInt(s);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12977
    public int 소수_만들기(int[] nums) {
        // 배열 길이
        int n = nums.length;
        // 소수 카운트 변수
        int count = 0;
        // 모든 경우의 수
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    // 숫자 3개를 더해서
                    int num = nums[i] + nums[j] + nums[k];
                    // 소수라면 카운트 증가
                    if (isPrime(num)) {
                        ++count;
                    }
                }
            }
        }
        // 카운트 리턴
        return count;
    }

    // 소수 판별 함수
    public boolean isPrime(int n) {
        // 제곱근 구하기
        int sqrt = (int) Math.sqrt(n);
        // 2부터 제곱근까지
        for (int i = 2; i <= sqrt; i++) {
            // 나누어 떨어진다면 소수가 아님
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12926
    public String 시저_암호(String s, int n) {
        // 알파벳 26자
        int alphabet = 26;
        // 스페이스 32
        int space = 32;
        // 대문자 A 65
        int upper = 65;
        // 소문자 a 97
        int lower = 97;
        // char 배열로 변환
        char[] chars = s.toCharArray();
        // 각각의 원소마다
        for (int i = 0; i < chars.length; i++) {
            // 스페이스라면 밀지 않음
            if (chars[i] == space) {
                continue;
            }
            // 대문자 소문자 여부 확인
            boolean isLower = chars[i] >= lower;
            // 0 - 26 범위로 변경
            chars[i] = (char) (isLower ? chars[i] - lower : chars[i] - upper);
            // n 만큼 밀기
            chars[i] += n;
            // 0 - 26 범위로 조정
            chars[i] %= alphabet;
            // 소문자 97~, 대문자 65~ 범위로 변경
            chars[i] = (char) (isLower ? chars[i] + lower : chars[i] + upper);
        }
        // 문자열로 변환하여 리턴
        return new String(chars);
        // Character.isLowerCase, Character.isUpperCase, (ch - 'a' + n) % 26 + 'a'
    }

    // https://programmers.co.kr/learn/courses/30/lessons/72410
    public String 신규_아이디_추천(String new_id) {
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = new_id.replaceAll("\\.{2,}", ".");
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        }
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (new_id.length() < 3) {
            while (new_id.length() != 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        // 리턴
        return new_id;
        // '.'이 2개 이상 -> "[.]{2,}", 시작이나 끝이 '.' -> "^[.]|[.]$"
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12928
    public int 약수의_합(int n) {
        // 약수를 구해서 모두 더하기
        return getSubmultiple(n).stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 약수 구하기
    public List<Integer> getSubmultiple(int n) {
        // 자동 정렬이 되도록 트리셋 사용
        Set<Integer> set = new TreeSet<>();
        // 제곱근 이하까지만 계산하기
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            // 나누어 떨어지면 나누는 수와 몫을 저장
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        // 리스트로 바꿔서 리턴
        return new ArrayList<>(set);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/77884
    public int 약수의_개수와_덧셈(int left, int right) {
        int answer = 0;
        // left 부터 right 까지
        for (int i = left; i <= right; i++) {
            // 위에서 만든 약수 구하기 함수
            int count = getSubmultiple(i).size();
            // 짝수면 더하고
            if (count % 2 == 0) {
                answer += i;
            }
            // 홀수면 빼기
            else {
                answer -= i;
            }
        }
        return answer;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12940
    public int[] 최대공약수와_최소공배수(int n, int m) {
        // 큰수 작은수로 구분
        int high = Integer.max(n, m);
        int low = Integer.min(n, m);
        // 각각 약수 구하기
        List<Integer> highSubmultiple = getSubmultiple(high);
        List<Integer> lowSubmultiple = getSubmultiple(low);
        // 최대공약수, 최소공배수
        int max = 1;
        int min;
        // 작은수 약수만큼 반복
        for (Integer value : lowSubmultiple) {
            // 큰수쪽에서 포함하고있다면 최대공약수 바꾸기
            if (highSubmultiple.contains(value)) {
                max = Integer.max(max, value);
            }
        }
        // 최소공배수 설정
        min = high * low / max;
        // 배열에 담아서 리턴
        return new int[]{max, min};
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12982
    public int 예산(int[] d, int budget) {
        // 부서별 신청 금액 오름차순 정렬
        int[] requests = d.clone();
        Arrays.sort(requests);
        // 작은 금액부터
        int count = 0;
        for (int request : requests) {
            // 예산 낭비
            budget -= request;
            // 남은 예산 없으면 탈출
            if (budget < 0) {
                break;
            }
            // 카운트 증가
            ++count;
        }
        // 리턴
        return count;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/87389
    public int 나머지가_1이_되는_수_찾기(int n) {
        // (n - 1)을 만들 수 있는 약수들에서 1을 제외한 가장 작은 값
        return getSubmultiple(n - 1).get(1);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42748
    public int[] K번째수(int[] array, int[][] commands) {
        // 정답 배열 선언
        int n = commands.length;
        int[] answer = new int[n];
        // commands 갯수만큼
        for (int i = 0; i < n; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int pick = commands[i][2] - 1;
            // 시작부터 끝 범위까지 카피 후 정렬
            int[] subArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArray);
            // 정답 배열에 담기
            answer[i] = subArray[pick];
        }
        return answer;
    }

    // https://hanghaealgorithm.oopy.io/
    public String 신대륙_발견(int month, int day) {
        // 1-12월 각 날짜, 인덱스 계산 편하게 하기 위해 맨 앞에 0 삽입
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 98일 - 이번달 남은 날짜
        int left = 98 - days[month] + day;
        month = nextMonth(month);
        // 한달 총 날짜보다 남은 날이 많다면 반복
        while (left > days[month]) {
            // 한달만큼 빼고 다음달 설정
            left -= days[month];
            month = nextMonth(month);
        }
        // 종료일 저장
        day = left;
        // 스트링 리턴
        return month + "월 " + day + "일";
    }

    // 다음달 계산기
    public int nextMonth(int month) {
        return ++month > 12 ? 1 : month;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/12921
    public int 소수_찾기(int n) {
        // 편한 인덱스 계산을 위해 범위를 +1
        boolean[] primes = new boolean[n + 1];
        // 0과 1은 소수가 아님
        primes[0] = true;
        primes[1] = true;
        // 2부터 끝까지
        for (int i = 2; i < primes.length; i++) {
            // 소수가 아닌 수는 추가 계산 X
            if (primes[i]) {
                continue;
            }
            // 소수라면 해당 소수의 배수 모두 아님 처리하기
            for (int j = 2; i * j < primes.length; j++) {
                primes[i * j] = true;
            }
        }
        // 남은것만 카운트
        return (int) IntStream.range(0, primes.length)
                .filter(i -> !primes[i])
                .count();
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42889
    public int[] 실패율(int N, int[] stages) {
        // Stage 배열 초기화
        Stage[] game = new Stage[N];
        for (int i = 0; i < N; i++) {
            game[i] = new Stage(i + 1);
        }
        // 각 스테이지마다
        for (int stage : stages) {
            // 인덱스 계산을 위해 1 빼기
            --stage;
            // N + 1 입력, 마지막 스테이지까지 클리어한 사람
            if (stage == game.length) {
                --stage;
                game[stage].clear();
            }
            // N 스테이지 도전중
            else {
                game[stage].arrive();
            }
            // N - 1 스테이지까지 클리어했음
            for (int i = 0; i < stage; i++) {
                game[i].clear();
            }
        }
        // 실패율 내림차순, 같다면 번호 오름차순 정렬 후 스테이지 번호 배열로 변환하여 리턴
        return Arrays.stream(game)
                .sorted()
                .mapToInt(Stage::getStageNum)
                .toArray();
    }

    class Stage implements Comparable<Stage> {
        // 스테이지 번호
        int stageNum;
        // 도달한 사람
        int arrive;
        // 클리어한 사람
        int clear;

        // 생성자
        public Stage(int stageNum) {
            this.stageNum = stageNum;
            this.arrive = 0;
            this.clear = 0;
        }

        // 스테이지 번호
        public int getStageNum() {
            return this.stageNum;
        }

        // 스테이지 도착 처리
        public void arrive() {
            ++this.arrive;
        }

        // 스테이지 클리어 처리
        public void clear() {
            ++this.arrive;
            ++this.clear;
        }

        // 실패율 계산 함수
        public double fail() {
            if (arrive == 0) {
                return 0;
            }
            return (double) (arrive - clear) / arrive;
        }

        // 실패율 내림차순, 같다면 번호 오름차순 비교
        @Override
        public int compareTo(Stage s) {
            int compare = Double.compare(this.fail(), s.fail());
            if (compare == 0) {
                return this.stageNum - s.getStageNum();
            }
            return compare;
        }
    }

    // https://programmers.co.kr/learn/courses/30/lessons/1845
    public int 폰켓몬(int[] nums) {
        // 집합 선언
        Set<Integer> pokemons = new HashSet<>();
        // 가져갈 수 있는 포켓몬은 연구실에 있는 N마리의 절반까지
        int half = nums.length / 2;
        // 포켓몬 종류별로 담기
        for (int num : nums) {
            pokemons.add(num);
        }
        // 포켓몬 종류, 절반 중 작은거 리턴
        return Integer.min(pokemons.size(), half);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42862
    public int 체육복(int n, int[] lost, int[] reserve) {
        // 여벌옷 집합에 저장
        Set<Integer> reserveSet = new HashSet<>();
        for (int i : reserve) {
            reserveSet.add(i);
        }
        // 도난여부 집합에 저장
        Set<Integer> lostSet = new HashSet<>();
        for (int i : lost) {
            // 여벌 옷을 가지고 있었다면
            if (reserveSet.contains(i)) {
                // 가지고 있던 옷 사용
                reserveSet.remove(i);
            }
            // 아니라면
            else {
                // 도난처리
                lostSet.add(i);
            }
        }
        // 빌려주기
        int count = 0;
        for (Integer integer : lostSet) {
            // 앞사람부터 체크
            if (reserveSet.contains(integer - 1)) {
                // 빌려입기
                reserveSet.remove(integer - 1);
                ++count;
            }
            // 뒷사람 체크
            else if (reserveSet.contains(integer + 1)) {
                // 빌려입기
                reserveSet.remove(integer + 1);
                ++count;
            }
        }
        // 결과 리턴
        return n - lostSet.size() + count;
    }

    // https://programmers.co.kr/learn/courses/30/lessons/17681
    public String[] 비밀지도(int n, int[] arr1, int[] arr2) {
        // 두 지도를 합칠 배열 선언
        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            // or 비트연산으로 합침
            map[i] = arr1[i] | arr2[i];
        }
        // 문자열을 n자리로 만들어줄 포맷 설정
        String format = "%" + n + "s";
        // 숫자 -> 문자열 변환하여 리턴
        return Arrays.stream(map)
                .mapToObj(num -> {
                    // 숫자 -> 2진법 문자열
                    String binary = Integer.toBinaryString(num);
                    // "11" -> "   11" n자리 변환
                    String formatted = String.format(format, binary);
                    // 1은 #으로, 0은 공백으로 바꾸기
                    return formatted.replaceAll("1", "#").replaceAll("0", " ");
                })
                .toArray(String[]::new);
    }

    // https://programmers.co.kr/learn/courses/30/lessons/67256
    public String 키패드_누르기(int[] numbers, String hand) {
        // 초기 손 위치, 오른손 #, 왼손
        Point rightThumb = new Point(3, 2);
        Point leftThumb = new Point(3, 0);
        // 문자열 이어붙이기
        StringBuilder sb = new StringBuilder();
        // 어느손잡이
        boolean flag = hand.equals("right");

        for (int number : numbers) {
            switch (number) {
                // 1, 4, 7은 왼손으로 누름
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    leftThumb.setPosition(number);
                    break;
                // 3, 6, 9는 오른손으로 누름
                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    rightThumb.setPosition(number);
                    break;
                // 2, 5, 8, 0은 가까운 손가락으로 누름
                default:
                    int compare = rightThumb.distance(number) - leftThumb.distance(number);
                    // 거리가 같다면 주로 사용하는 손가락으로 누름
                    if (compare == 0) {
                        if (flag) {
                            sb.append("R");
                            rightThumb.setPosition(number);
                        } else {
                            sb.append("L");
                            leftThumb.setPosition(number);
                        }
                    }
                    // 오른손이 가깝다면
                    else if (compare < 0) {
                        sb.append("R");
                        rightThumb.setPosition(number);
                    }
                    // 왼손이 가깝다면
                    else {
                        sb.append("L");
                        leftThumb.setPosition(number);
                    }
                    break;
            }
        }
        // 문자열로 리턴
        return sb.toString();
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // 손가락 위치 조정 함수
        public void setPosition(int n) {
            int[] pos = calculatePosition(n);
            this.x = pos[0];
            this.y = pos[1];
        }

        // 번호와 손가락 사이 거리 계산 함수
        public int distance(int n) {
            int[] pos = calculatePosition(n);
            return Math.abs(this.x - pos[0]) + Math.abs(this.y - pos[1]);
        }

        // 숫자를 xy 좌표로 바꿔주는 함수
        private int[] calculatePosition(int n) {
            --n;
            // 0이 입력되면 위치 조정
            if (n == -1) {
                n = 10;
            }
            return new int[]{n / 3, n % 3};
        }
    }

    // https://school.programmers.co.kr/learn/courses/30/lessons/12939
    public String 최댓값과_최솟값(String s) {
        // 공백을 기준으로 분리해서 숫자로 바꾸고 정렬하여 리스트로 변환
        List<Integer> list = Arrays.stream(s.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        // 시작 인덱스: 최솟값, 끝 인덱스: 최댓값
        return list.get(0) + " " + list.get(list.size() - 1);
    }
}
