package com.kyy.springboot.study.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.kyy.springboot.study.BoardSpringJpaStudyApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

    /**
     * 파일 업로드 폼 화면 호출
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/uploadGet")
    public String provideUploadInfo(Model model) {
        File rootFolder = new File(BoardSpringJpaStudyApplication.ROOT);
        List<String> fileNames = Arrays.stream(rootFolder.listFiles())
                .map(f -> f.getName())
                .collect(Collectors.toList());

        model.addAttribute("files",
                Arrays.stream(rootFolder.listFiles())
                        .sorted(Comparator.comparingLong(f -> -1 * f.lastModified()))
                        .map(f -> f.getName())
                        .collect(Collectors.toList())
        );

        return "uploadForm";
    }

    /**
     * 파일 업로드 처리
     * @param name
     * @param file
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/uploadPost")
    public String handleFileUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (name.contains("/uploadGet")) {
            redirectAttributes.addFlashAttribute("message", "Folder separators not allowed");
            return "redirect:/uploadGet";
        }
        if (name.contains("/uploadGet")) {
            redirectAttributes.addFlashAttribute("message", "Relative pathnames not allowed");
            return "redirect:/uploadGet";
        }

        if (!file.isEmpty()) {
            try {
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(new File(BoardSpringJpaStudyApplication.ROOT + "/" + name)));
                FileCopyUtils.copy(file.getInputStream(), stream);
                stream.close();
                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded " + name + "!");
            }
            catch (Exception e) {
                redirectAttributes.addFlashAttribute("message",
                        "You failed to upload " + name + " => " + e.getMessage());
            }
        }
        else {
            redirectAttributes.addFlashAttribute("message",
                    "You failed to upload " + name + " because the file was empty");
        }

        return "redirect:/uploadGet";
    }

}
