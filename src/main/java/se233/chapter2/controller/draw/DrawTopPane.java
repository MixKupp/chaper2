package se233.chapter2.controller.draw;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import se233.chapter2.controller.AllEventHandler;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

// Convert the two sub-panes in the CurrencyPane class into Callable objects - START
public class DrawTopPane extends FlowPane implements Callable<FlowPane> {
    private Button refresh;
    private Button add;
    private Button config;
    private Label update;

    public DrawTopPane() {
        refresh = new Button("Refresh");
        add = new Button("Add");
        config = new Button("Config");
        refresh.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AllEventHandler.onRefresh();
            }
        });
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AllEventHandler.onAdd();
            }
        });
        config.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AllEventHandler.onConfig();
            }
        });
        update = new Label();
        update.setText(String.format("Last update: %s                                                           ", LocalDateTime.now()));
    }

    @Override
    public FlowPane call() throws Exception {
        FlowPane topPane = new FlowPane();
        topPane.setPadding(new Insets(10));
        topPane.setHgap(10);
        topPane.setPrefSize(640, 20);
        topPane.getChildren().addAll(refresh, update, add, config);

        return topPane;
    }
}