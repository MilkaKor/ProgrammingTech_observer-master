package ShapeComponents.ContextComponent;

import ObserverComponents.Observer;
import ShapeComponents.factory.IFactory;
import ShapeComponents.factory.ShapeFactory;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GraphicComponent implements Observer {
    private IFactory factory;
    private GraphicsContext context;
    private List<String> shapes = List.of("Круг","Квадрат");
    public GraphicComponent(GraphicsContext context){
        this.context = context;
        factory = new ShapeFactory();
    }

    @Override
    public void update(Date date) {
        if (date.getSeconds() % 10 == 0){
            var shape = factory.createShape(shapes.get(new Random().nextInt(0,2)));
            var x = new Random().nextInt(1, (int) this.context.getCanvas().getHeight());
            var y = new Random().nextInt(1, (int) this.context.getCanvas().getWidth());
            shape.setXY(x,y);
            shape.draw(this.context);
        }
    }
}
