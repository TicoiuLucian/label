package com.alten.label.controller.swagger.doc;

import com.alten.label.controller.model.LabelList;
import com.alten.label.controller.model.ListElement;
import com.alten.label.controller.model.Metadata;
import com.alten.label.controller.swagger.example.LabelListExample;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Create a new label list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> createLabelList(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Create a new label list",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = LabelList.class),
                    examples = {@ExampleObject(
                            name = "Example 1",
                            value = LabelListExample.LABEL_LIST_IMPORT,
                            description = "Description text")})
            })
                                         @RequestBody LabelList labelList);

    @Operation(summary = "Add list elements to label list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping(value = "/list-element", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> addListElementsToLabelList(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Add list elements to label list",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ListElement.class),
                    examples = {@ExampleObject(
                            name = "Example 1",
                            value = LabelListExample.LABEL_LIST_ELEMENT,
                            description = "Description text")})
            })
                                                    @RequestBody List<ListElement> listElements,
                                                    @Parameter(name = "label-list-name", example = "LabelList-1672836331316.json") @RequestParam(name = "label-list-name") String labelListName);

    @Operation(summary = "Get label list file names")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class),
                            examples = {@ExampleObject(
                                    name = "200-OK",
                                    value = "Label_list.json",
                                    description = "Get label list file names")}),
                    }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class),
                            examples = {@ExampleObject(
                                    name = "500-Internal Server Error",
                                    value = "Internal Server Error")})
                    })
    })
    @Parameter(in = ParameterIn.QUERY, name = "path", schema = @Schema(example = "Campagne_Guillaume", type = "string"))
    @GetMapping(value = "/files")
    List<String> getAllLabelListsFileName(@RequestParam String path);

    @PutMapping(value = "/metadata", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> addMetadataToLabelList(@RequestBody Metadata metadata,
                                                @RequestParam(name = "label-list-name") String labelListName);

    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> upload(@RequestBody String labelListName) throws Exception;

    @Operation(summary = "Delete label list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
            @ApiResponse(responseCode = "404", description = "File Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @Parameter(in = ParameterIn.QUERY, name = "file_to_delete", schema = @Schema(example = "LabelList-test.json", type = "string"))
    @DeleteMapping
    ResponseEntity<Void> deleteLabelList(@RequestParam(name = "file_to_delete") String labelListName);

    @Operation(summary = "Delete label from label list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
            @ApiResponse(responseCode = "404", description = "File Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })

    @DeleteMapping(value = "/label")
    ResponseEntity<Void> deleteLabelFromLabelList(@Parameter(name = "labelListName", example = "LabelList-1672836931261.json") @RequestParam String labelListName,
                                                  @Parameter(name = "labelId", example = "2") @RequestParam Long labelId);

    @PutMapping(value = "/update-label-parents")
    ResponseEntity<Void> updateLabelElementParents(@RequestParam(name = "label-list-name") String labelListName, @RequestParam(name = "label-id") Long labelId, @RequestBody List<ListElement> listElement);

    @PutMapping(value = "/update-label")
    ResponseEntity<Void> updateLabelElement(@RequestParam(name = "label-list-name") String labelListName, @RequestParam(name = "label-id") Long labelId, @RequestBody ListElement listElement);
}
