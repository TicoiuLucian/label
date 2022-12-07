package com.alten.label.controller;

import com.alten.label.controller.model.LabelList;
import com.alten.label.controller.swagger.example.LabelListExample;
import com.alten.label.service.LabelListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/labels")
public class LabelListController {

    @Autowired
    LabelListService labelListService;


    @Operation(summary = "Import a new label list")
    //TODO ApiReponses are not correct, sort it out with Thierry
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LabelList.class),
                            examples = {@ExampleObject(
                                    name = "200-OK",
                                    value = "OK")})
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LabelList.class),
                            examples = {@ExampleObject(
                                    name = "500-Internal Server Error",
                                    value = "Internal Server Error")})
                    })
    })

    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> upload(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Set here device category, duration and propertyId",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = LabelList.class),
                    examples = {@ExampleObject(
                            name = "Example 1",
                            value = LabelListExample.LABEL_LIST_IMPORT,
                            description = "Description text")})
            })
                                         @RequestBody LabelList labelList) throws Exception {
        return labelListService.convertRequestBodyToJsonFile(labelList);
    }

    @Operation(summary = "Get label list")
    //TODO ApiReponses are not correct, sort it out with Thierry
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class),
                            examples = {@ExampleObject(
                                    name = "200-OK",
                                    value = "file  Label_list.json")}),

                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LabelList.class),
                            examples = {@ExampleObject(
                                    name = "500-Internal Server Error",
                                    value = "Internal Server Error")})
                    })
    })
    @Parameter(in = ParameterIn.QUERY, name = "path", schema = @Schema(example = "Campagne_Guillaume", type = "string"))
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getList(@RequestParam(required = false) String path) {
        return labelListService.getLabelList(path);
    }

    @Operation(summary = "Get file content")
    //TODO ApiReponses are not correct, sort it out with Thierry
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class),
                            examples = {@ExampleObject(
                                    name = "200-OK",
                                    value = "??????")}),

                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LabelList.class),
                            examples = {@ExampleObject(
                                    name = "500-Internal Server Error",
                                    value = "Internal Server Error")})
                    })
    })
    @Parameter(in = ParameterIn.QUERY, name = "file_to_read", schema = @Schema(example = "Label_list.json", type = "string"))
    @GetMapping(value = "/file-content", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFileContent(@RequestParam(name = "file_to_read") String fileToRead) {
        return labelListService.getFileContent(fileToRead);
    }

    @Operation(summary = "Delete label list")
    //TODO ApiReponses are not correct, sort it out with Thierry
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
            @ApiResponse(responseCode = "404", description = "File Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")

    })
    @Parameter(in = ParameterIn.QUERY, name = "file_to_delete", schema = @Schema(example = "Label_list.json", type = "string"))
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> delete(@RequestParam(name = "file_to_delete") String fileToDelete) {
        try {
            labelListService.deleteFile(fileToDelete);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

