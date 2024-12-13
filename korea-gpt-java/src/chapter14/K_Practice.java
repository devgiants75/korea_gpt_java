package chapter14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class K_Practice {
    public static void main(String[] args) {
        List<String> fileNames = Arrays.asList(
                "document.pdf", "image1.png", "video.mp4"
                , "presentation.ppt", "image2.png", "image3.jpg"
                , "image4.png", "javascript.js"
        );

        // 1. 특정 확장자(.png, .jpg) 필터링
        List<String> filteredFiles = fileNames.stream()
                // .endsWith(""): 해당 문자열로 끝나는 데이터는 true 반환
                .filter(name -> name.endsWith(".png") || name.endsWith(".jpg"))
                .collect(Collectors.toList());

        System.out.println("이미지 파일 필터링: " + filteredFiles);
        // 이미지 파일 필터링: [image1.png, image2.png, image3.jpg, image4.png]

        // 2. 파일 이름을 알파벳 순으로 정렬
        List<String> sortedFiles = fileNames.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("정렬된 파일: " + sortedFiles);
        // 정렬된 파일: [document.pdf, image1.png, image2.png, image3.jpg, image4.png, javascript.js, presentation.ppt, video.mp4]
    }
}