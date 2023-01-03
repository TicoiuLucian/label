package com.alten.label.controller.swagger.doc;

import com.alten.label.controller.model.LabelList;
import com.alten.label.controller.model.ListElement;
import com.alten.label.controller.model.Metadata;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/label-list")
public interface LabelListDoc {


//    @Operation(summary = "Get label list")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "OK - request has succeeded",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = String.class),
//                            examples = {@ExampleObject(
//                                    name = "200-OK",
//                                    value = "file  Label_list.json")}),
//
//                    }),
//            @ApiResponse(responseCode = "500", description = "Internal Server Error",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = LabelList.class),
//                            examples = {@ExampleObject(
//                                    name = "500-Internal Server Error",
//                                    value = "Internal Server Error")})
//                    })
//    })
//    @Parameter(in = ParameterIn.QUERY, name = "path", schema = @Schema(example = "Campagne_Guillaume", type = "string"))
//    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<String> getList(@RequestParam(required = false) String path);
//
//    @Operation(summary = "Get file content")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "OK - request has succeeded",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = String.class),
//                            examples = {@ExampleObject(
//                                    name = "200-OK",
//                                    value = "??????")}),
//
//                    }),
//            @ApiResponse(responseCode = "500", description = "Internal Server Error",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = LabelList.class),
//                            examples = {@ExampleObject(
//                                    name = "500-Internal Server Error",
//                                    value = "Internal Server Error")})
//                    })
//    })
//    @Parameter(in = ParameterIn.QUERY, name = "file_to_read", schema = @Schema(example = "Label_list.json", type = "string"))
//    @GetMapping(value = "/file-content", produces = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<String> getFileContent(@RequestParam(name = "file_to_read") String fileToRead);
//
//    @Operation(summary = "Delete label list")
//    //TODO ApiReponses are not correct, sort it out with Thierry
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
//            @ApiResponse(responseCode = "404", description = "File Not Found"),
//            @ApiResponse(responseCode = "500", description = "Internal Server Error")
//
//    })
//    @Parameter(in = ParameterIn.QUERY, name = "file_to_delete", schema = @Schema(example = "Label_list.json", type = "string"))
//    @DeleteMapping(value = "/delete")
//    ResponseEntity<Void> delete(@RequestParam(name = "file_to_delete") String fileToDelete);

    //
//    @Operation(summary = "Import a new label list")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "OK - request has succeeded",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = LabelList.class),
//                            examples = {@ExampleObject(
//                                    name = "200-OK",
//                                    value = "OK")})
//                    }),
//            @ApiResponse(responseCode = "500", description = "Internal Server Error",
//                    content = {@Content(mediaType = "application/json",
//                            schema = @Schema(implementation = LabelList.class),
//                            examples = {@ExampleObject(
//                                    name = "500-Internal Server Error",
//                                    value = "Internal Server Error")})
//                    })
//    })
//
//    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
//    ResponseEntity<String> upload(@io.swagger.v3.oas.annotations.parameters.RequestBody(
//            description = "Set here device category, duration and propertyId",
//            content = {@Content(mediaType = "application/json",
//                    schema = @Schema(implementation = LabelList.class),
//                    examples = {@ExampleObject(
//                            name = "Example 1",
//                            value = LabelListExample.LABEL_LIST_IMPORT,
//                            description = "Description text")})
//            })
//                                  @RequestBody LabelList labelList) throws Exception;
//
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createLabelList(@RequestBody LabelList labelList);

    @PostMapping(value = "/list-element", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> addListElementsToLabelList(@RequestBody List<ListElement> listElements,
                                                    @RequestParam(name = "label-list-name") String labelListName);

    @GetMapping
    List<LabelList> getAllLabelLists();

    @GetMapping(value = "/files")
    List<String> getAllLabelListsFileName();

    @PostMapping(value = "/metadata", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> addMetadataToLabelList(@RequestBody Metadata metadata,
                                                @RequestParam(name = "label-list-name") String labelListName);

    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> upload(@RequestBody String labelListName) throws Exception;

    @DeleteMapping
    ResponseEntity<Void> deleteLabelList(@RequestParam String labelListName);

    @DeleteMapping(value = "/label")
    ResponseEntity<Void> deleteLabelFromLabelList(@RequestParam String labelListName, @RequestParam Long labelId);

    @PutMapping(value = "/update-label-parents")
    ResponseEntity<Void> updateLabelElementParents(@RequestParam(name = "label-list-name") String labelListName, @RequestParam(name = "label-id") Long labelId, @RequestBody List<ListElement> listElement);

    @PutMapping(value = "/update-label")
    ResponseEntity<Void> updateLabelElement(@RequestParam(name = "label-list-name") String labelListName, @RequestParam(name = "label-id") Long labelId, @RequestBody ListElement listElement);
}
