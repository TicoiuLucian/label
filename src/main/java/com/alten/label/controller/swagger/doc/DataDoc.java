package com.alten.label.controller.swagger.doc;

import com.alten.label.controller.model.Data;
import com.alten.label.controller.model.DataLocation;
import com.alten.label.controller.swagger.example.DataExample;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface DataDoc {


    @Operation(summary = "Create a Date file")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    ResponseEntity<Void> createData(
            @RequestBody(
                    description = "Creates a separate Data file",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Data.class),
                                    examples = {
                                            @ExampleObject(
                                                    name = "Example 1",
                                                    value = DataExample.CREATE_DATA_REQUEST,
                                                    description = "Simple example"
                                            )
                                    }
                            )
                    }) Data data);

    @Operation(summary = "Add line to a Date file")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    ResponseEntity<Void> addLine(
            @Parameter(name = "dataName", example = "data1") String dataName,
            @Parameter(name = "line", example = "1,2,3") String line);

    @Operation(summary = "Add lines to a Date file")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK - request has succeeded"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    ResponseEntity<Void> importLines(@Parameter(name = "dataLocation", example = "LOCAL") DataLocation dataLocation,
                                     @Parameter(name = "dataName", example = "data1") String dataName,
                                     @Parameter(name = "containsHeader", example = "false") Boolean containsHeader,
                                     @Parameter(name = "file") MultipartFile file);
}
