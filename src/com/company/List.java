package com.company;

public  class List<Integer> {
    private int size=0;//размер списка
    Entery<Integer> first;//фактически первый элемента
    Entery<Integer> last;//фактически последний элемента

    public List(){//конструктор,который ссылает фактически первый и последний элемент друг на друга и имеют имеют значения null
        last=new Entery<Integer>(null,null);
        first=new Entery<Integer>(null,last);
    }

    public int size(){
        return size;
    }//метод,возвращающий размер списка

    public void addLast(Integer a){//метод, добавляющий элемент в конец списка
        Entery<Integer> prev=last;//создание элемента ,который ссылается на фактически паследний элемент
        prev.setCurrentElement(a);//установление значения созданного элемента
        last=new Entery<Integer>(null,null);//переопрделение ссылки фактически паследнего элемента
        prev.setNextElement(last);//переопределение ссылки созданного элемента на следующий элемент
        size++;//увеличчение размера списка на единицу
    }

    public void addFirst(Integer a){//метод, добавляющий элемент в начало списка
        Entery<Integer> next=first;//создание элемента ,который ссылается на фактически первый элемент
        next.setCurrentElement(a);//установление значения созданного элемента
        first=new Entery<Integer>(null,next);//переопрделение ссылки фактически первого элемента
        size++;//увеличчение размера списка на единицу
    }

    public void addByIndex(int index,Integer a){//метод,добавляющий элемент в список по индексу
        Entery<Integer> target=first.getNextElement();//создание элемента,который ссылается на первый элемент списка
        for(int i=0;i<=index-1;i++){//поиск элемента по индеку
            target=getNextElement(target);
        }
        Entery<Integer> prev=target;//создание элемента который ссылается на элемент по индексу
        Integer temp=target.getCurrentElement();//помещаем в переменную значение элемента по индексу
        prev.setCurrentElement(a);//установление значения созданного элемента
        target=new Entery<Integer>(temp,target.getNextElement());//переопределение элемента по индексу
        prev.setNextElement(target);//переопределение ссылки созданного элемента на следующий элемент
        size++;//увеличчение размера списка на единицу

    }

    public Integer get(int index){//метод возвращающий элемент из списка по индексу
        Entery<Integer> target=first.getNextElement();//создание элемента,который ссылается на первый элемент списка
        for(int i=0; i<=index-1 ;i++){//поиск элемента по индеку
            target=getNextElement(target);
        }
        return target.getCurrentElement();//возврат найденного  элемент из списка
    }

    public Entery<Integer> getNextElement(Entery<Integer> current){//метод возвращающий ссылку текущего элемента на следующий
        return current.getNextElement();
    }


    public static class Entery<Integer>{//класс для создания новго элемента списка
        Integer element;//элемента списка
        Entery<Integer> next;//ссылка на следующий элемент

        Entery(Integer element,Entery<Integer> next){//конструктор создающий элемент,который ссылается на следющий и предыдущий элемент
            this.element=element;
            this.next=next;
        }
        public Integer getCurrentElement(){//метод возвращающий значение текущего элемента
            return element;
        }
        public void setCurrentElement(Integer element){//метод устанавливающий значение текущего элемента
            this.element=element;
        }
        public Entery<Integer> getNextElement(){//метод возвращающий ссылку на следующий
            return next;
        }
        public void setNextElement(Entery<Integer> next){//метод устанавливающий ссылку на следующий элемент
            this.next=next;
        }


    }

}