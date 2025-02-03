package fastcampus.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 점심 및 저녁 식사 조를 구성하기 위해 신청자를 무작위로 섞고 조를 나눔
 */
public class TeamDinner {

  public static void main(String[] args) throws IOException {

    System.out.println("참여 신청자를 공백으로 구분하여 입력해 주세요.");
    System.out.println("예시: 이성계 세종대왕 정도전 이순신 정약용 세조 장영실 광해군 허준 김정호");
    System.out.println();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력 받기
    String[] lunchApplicants = getInputAsArray(br, "* 점심 신청자 입력:");
    String[] dinnerApplicants = getInputAsArray(br, "* 저녁 신청자 입력:");
    String[] flexibleApplicants = getInputAsArray(br, "* 무관 신청자 입력:");

    System.out.print("* 조 인원 입력:");
    int groupSize = Integer.parseInt(br.readLine());

    // 점심 신청자 랜덤 섞기
    List<String> lunchShuffledList = shuffleApplicants(lunchApplicants);

    // 저녁 신청자 랜덤 섞기
    List<String> dinnerShuffledList = shuffleApplicants(dinnerApplicants);

    // 유동 신청자 랜덤 섞기
    List<String> flexibleShuffledList = shuffleApplicants(flexibleApplicants);

    // 무관 신청자 배정
    distributeFlexibleApplicants(flexibleShuffledList, lunchShuffledList, dinnerShuffledList,
        groupSize);

    // 점심 조 편성
    List<List<String>> lunchGroupList = createGroups(lunchShuffledList, groupSize);

    // 저녁 조 편성
    List<List<String>> dinnerGroupList = createGroups(dinnerShuffledList, groupSize);

    // 결과 출력
    System.out.println("점심 조 편성 결과:");
    printGroups(lunchGroupList);

    System.out.println("저녁 조 편성 결과:");
    printGroups(dinnerGroupList);
  }

  /**
   * 사용자의 입력을 받아 처리 후 배열로 반환
   */
  private static String[] getInputAsArray(BufferedReader br, String prompt) throws IOException {
    System.out.print(prompt);
    return br.readLine().split(" ");
  }

  /**
   * 신청자의 목록을 랜덤하게 섞은 후 리스트 형태로 반환
   *
   * @param applicants 신청자의 문자열 배열
   * @return 랜덤으로 섞인 신청자 리스트
   */
  private static List<String> shuffleApplicants(String[] applicants) {
    List<String> shuffledList = new ArrayList<>();
    Collections.addAll(shuffledList, applicants);
    Collections.shuffle(shuffledList);
    return shuffledList;
  }

  /**
   * 무관 신청자를 점심 조와 저녁 조에 번갈아 배정
   *
   * @param flexibleApplicantList 무관 신청자 리스트
   * @param lunchList             점심 조 리스트
   * @param dinnerList            저녁 조 리스트
   */
  private static void distributeFlexibleApplicants(
      List<String> flexibleApplicantList,
      List<String> lunchList,
      List<String> dinnerList,
      int groupSize) {

    boolean assignToLunch = true;
    for (String applicant : flexibleApplicantList) {
      if (assignToLunch) {
        lunchList.add(applicant);
      } else {
        dinnerList.add(applicant);
      }
      assignToLunch = !assignToLunch;
    }

    // 점심 조의 크기가 groupSize로 나누어 떨어지지 않을 경우 나머지를 저녁 조로 이동
    int lunchSizeRemainder = lunchList.size() % groupSize;
    if (lunchSizeRemainder != 0) {
      for (int i = 0; i < lunchSizeRemainder; i++) {
        dinnerList.add(lunchList.remove(lunchList.size() - 1));
      }
    }
  }

  /**
   * 신청자를 지정된 인원 수로 조를 나눔
   *
   * @param applicantList 신청자 리스트
   * @param groupSize     조 인원 수
   * @return 생성된 조 리스트
   */
  private static List<List<String>> createGroups(List<String> applicantList, int groupSize) {

    List<List<String>> groupList = new ArrayList<>();
    List<String> currentGroupList = new ArrayList<>();

    for (String applicant : applicantList) {
      currentGroupList.add(applicant);

      // 현재 조가 groupSize만큼 찼다면 조 리스트에 추가
      if (currentGroupList.size() == groupSize) {
        groupList.add(new ArrayList<>(currentGroupList));
        currentGroupList.clear();
      }
    }

    // 남은 신청자 처리
    if (!currentGroupList.isEmpty()) {
      distributeRemainingApplicants(groupList, currentGroupList);
    }

    return groupList;
  }

  /**
   * 남은 신청자들을 기존 조에 배치
   *
   * <p>
   * 한 명이 남으면 첫 번째 조에 추가하고, 여러 명이 남으면 새로운 조를 생성
   * </p>
   *
   * @param groupList              생성된 조 리스트
   * @param remainingApplicantList 남은 신청자 리스트
   */
  private static void distributeRemainingApplicants(
      List<List<String>> groupList,
      List<String> remainingApplicantList) {

    if (remainingApplicantList.size() == 1 && !groupList.isEmpty()) {
      // 한 명이 남으면 첫 번째 조에 추가
      groupList.get(0).add(remainingApplicantList.get(0));
    } else {
      // 여러 명이 남으면 새로운 그룹으로 추가
      groupList.add(new ArrayList<>(remainingApplicantList));
    }
  }

  /**
   * 조 결과를 출력
   *
   * @param groupList 생성된 조 리스트
   */
  private static void printGroups(List<List<String>> groupList) {
    for (int i = 0; i < groupList.size(); i++) {
      System.out.println((i + 1) + " 조 : " + groupList.get(i));
    }
  }
}
