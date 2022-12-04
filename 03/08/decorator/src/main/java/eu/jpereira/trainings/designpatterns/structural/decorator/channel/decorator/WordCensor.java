package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannel;

public class WordCensor extends SocialChannelDecorator{
    private final String toBeCensored;
    public WordCensor(String toBeCensored){
        this.toBeCensored = toBeCensored;
    }

    public WordCensor(String toBeCensored, SocialChannel decoratedChannel) {
        this.toBeCensored = toBeCensored;
        this.delegate = decoratedChannel;
    }

    @Override
    public void deliverMessage(String message) {
        if(message.contains(toBeCensored)){
            message = message.replace(toBeCensored, "###");
        }
        delegate.deliverMessage(message);
    }

}
