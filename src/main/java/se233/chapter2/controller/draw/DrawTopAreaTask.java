package se233.chapter2.controller.draw;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import se233.chapter2.controller.AllEventHandler;
import se233.chapter2.model.Currency;
import java.util.concurrent.Callable;

public class DrawTopAreaTask implements Callable<HBox> {
    private Currency currency;
    private Button watch;
    private Button unWatch;
    private Button delete;

    public DrawTopAreaTask(Currency currency) {
        this.watch = new Button("Watch");
        // Add unwatch button
        this.unWatch = new Button("Unwatch");
        this.delete = new Button("Delete");
        this.watch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AllEventHandler.onWatch(currency.getShortcode());
            }
        });
        this.unWatch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AllEventHandler.onUnwatch(currency.getShortcode());
            }
        });
        this.delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AllEventHandler.onDelete(currency.getShortcode());
            }
        });
    }

    @Override
    public HBox call() throws Exception {
        HBox topArea = new HBox(10);
        topArea.setPadding(new Insets(5));
        // Add unwatch button
        topArea.getChildren().addAll(watch, unWatch, delete);
        ((HBox) topArea).setAlignment(Pos.CENTER_RIGHT);

        return topArea;
    }
}