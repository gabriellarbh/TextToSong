
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriellabarbieri
 */
public class Musica {
    private String musicaFinal;
    private String musicaRaw;
    private int octave;
    private int tempo;
    private int indexInstr;
    private static final int addVolume = 100;
    private static final int decTempo = 10;
    private static final int defaultOct = 5;
    private static final int defaultTempo = 120;
    
    public Musica(String input, int instrument){
        //Chamar função de parser
        this.musicaFinal = "";
        this.tempo = defaultTempo;
        this.octave = defaultOct;
        this.indexInstr = 0;
        musicaRaw = input.toLowerCase();
        char current;
        int i;
        for(i = 0; i < musicaRaw.length(); i++){
            current = musicaRaw.charAt(i);
            if(isNota(current))
                addNota(current, octave);
            else if (isDigit(current))
                octave = Character.getNumericValue(current);
            else 
                parseEspecialChar(current);  
        }
        
    }
    
    
    private boolean isNota(char nota){
        return (nota >= 'a' && nota <= 'z');
    }
    
    private boolean isDigit(char digit){
        return (digit >= '1' && digit <= '9');
    }
    
    private void addNota(char nota, int oitava){
        Nota nova = new Nota(nota,oitava);
        musicaFinal = musicaFinal + " " + Integer.toString(nova.getNota());
    }
    
    private void changeInstrument(){
        if(this.indexInstr == 127)
            this.indexInstr = 0;
        else
            this.indexInstr = this.indexInstr + 2;
        this.musicaFinal = this.musicaFinal + " I" + this.indexInstr;
    }
    
    private void decTempo(){
        this.tempo = this.tempo - decTempo;
        this.musicaFinal = this.musicaFinal + " T" + this.tempo;
    }

    public String getMusica(){
        return this.musicaFinal;
    }
    
    private void setVolume(int volume){
        this.musicaFinal = this.musicaFinal + " X[Volume]=" + volume;
    }
    
    private void parseEspecialChar(char current){
        int currentVolume = 10000;
        switch(current){
                    case '!':
                        currentVolume = currentVolume + addVolume;
                        setVolume(currentVolume);
                        break;
                    case '?':
                    case '.':
                        octave = defaultOct;
                        break;
                    case '\n':
                        changeInstrument();
                        break;
                    case ';':
                        decTempo();
                        break;  
                    case ',':
                        currentVolume = currentVolume - addVolume;
                        setVolume(currentVolume);
                    case ' ':
                        addNota('c',0);
                        break;
                    
                }
    }
 
    
    }
