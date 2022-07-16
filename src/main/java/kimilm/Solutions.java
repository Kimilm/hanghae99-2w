package kimilm;

import java.util.*;
import java.util.stream.Collectors;

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
}
