package com.alten.label.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScenarioController {


//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
//    public void upload(@RequestPart("file") @Valid @NotNull @NotBlank MultipartFile multipartFile) {
//
//        try {
//            final String fileLocation = saveMultipartToDisk(multipartFile);
//            CampaignModel response = objectMapper.readValue(new File(fileLocation), CampaignModel.class);
////            CampaignModel cm = new CampaignModel();
////            cm.setId(response.getId());
////            response.getDataList().forEach(x -> x.setCampaignModel(cm));
//
//            //            campaignDataRepository.saveAll(response.getDataList().stream().map(CampaignDataModel::toEntity).toList());
//            campaignRepository.save(response.toEntity());
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//    private String saveMultipartToDisk(MultipartFile multipartFile) throws Exception {
//        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
//        String fileName = date + multipartFile.getOriginalFilename();
//        String fileLocation = new File("src\\main\\resources\\static\\uploads").getAbsolutePath() + "\\" + fileName;
//        FileOutputStream output = new FileOutputStream(fileLocation);
//        output.write(multipartFile.getBytes());
//        output.close();
//        return fileLocation;
//    }
}
