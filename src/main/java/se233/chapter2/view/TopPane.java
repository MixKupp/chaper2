package se233.chapter2.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import se233.chapter2.controller.AllEventHandler;

import java.time.LocalDateTime;
import java.util.Locale;

public class TopPane extends FlowPane {
    private Button refresh;
    private Button add;
    private Label update;
    public TopPane() {
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setPrefSize(640, 20);
        add = new Button("Add");
        refresh = new Button("Refresh");
        update = new Label("Update");

        refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AllEventHandler.onRefresh();
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AllEventHandler.onAdd();
            }
        });
        refreshPane();
        this.getChildren().addAll(refresh, add, update);
    }
    public void refreshPane() {
        update.setText(String.format("Last update: %s", LocalDateTime.now().toString()));
    }
}
