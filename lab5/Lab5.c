#include <math.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct SinglyLinkedList {
  int data;
  struct SinglyLinkedList *next;
} singlylinkedlist;

typedef struct DoublyLinkedList {
  int data;
  struct DoublyLinkedList *next;
  struct DoublyLinkedList *prev;
} doublylinkedlist;

int counter_of_objects, z_counter = 0;

singlylinkedlist *create(int data);
doublylinkedlist *double_create(int data);
void add_element(int data6, singlylinkedlist *head);
void double_add_element(int data, doublylinkedlist *head);
void delete_object(singlylinkedlist *head, int object);
void double_delete_object(doublylinkedlist *head, int index);
void delete_szeros(singlylinkedlist *head);
void delete_dzeros(doublylinkedlist *head);
void display_list(singlylinkedlist *head);
void double_display_list(doublylinkedlist *head);

singlylinkedlist *create(int data) {
  singlylinkedlist *tmp = (singlylinkedlist *)malloc(sizeof(singlylinkedlist));
  tmp->data = data;
  tmp->next = NULL;
  return (tmp);
}

doublylinkedlist *double_create(int data) {
  doublylinkedlist *tmp = (doublylinkedlist *)malloc(sizeof(doublylinkedlist));
  tmp->data = data;
  tmp->next = NULL;
  tmp->prev = NULL;
  return (tmp);
}

void add_element(int data, singlylinkedlist *head) {
  singlylinkedlist *tmp = (singlylinkedlist *)malloc(sizeof(singlylinkedlist));
  tmp = create(data);
  singlylinkedlist *list = head;
  while (list->next != NULL)
    list = list->next;
  list->next = tmp;
}

void double_add_element(int data, doublylinkedlist *head) {
  doublylinkedlist *tmp = (doublylinkedlist *)malloc(sizeof(doublylinkedlist));
  tmp = double_create(data);
  doublylinkedlist *list = head;
  while (list->next != NULL)
    list = list->next;

  list->next = tmp;
  list->next->prev = list;
}

void delete_object(singlylinkedlist *head, int index) {
  singlylinkedlist *ptr_sec = head;

  if (index == counter_of_objects) {
    singlylinkedlist *p = head;
    while (p->next->next != NULL)
      p = p->next;
    p->next = NULL;
  } else
    for (int i = 1; i < counter_of_objects; i++) {
      if (i + 1 == index) {
        singlylinkedlist *a = ptr_sec;
        int data2 = ptr_sec->next->next->data;
        ptr_sec->next->next->data = a->data;
        ptr_sec->data = data2;
        ptr_sec->next = ptr_sec->next->next;
      }
      ptr_sec = ptr_sec->next;
    }
}

void double_delete_object(doublylinkedlist *head, int index) {
  doublylinkedlist *ptr_sec = head;

  if (index == counter_of_objects) {
    doublylinkedlist *p = head;
    while (p->next->next != NULL)
      p = p->next;
    p->next = NULL;
  } else
    for (int i = 1; i < counter_of_objects; i++) {
      if (i + 1 == index) {
        if (ptr_sec->next->data == 0)
          z_counter--;
        ptr_sec->next = ptr_sec->next->next;
      }
      ptr_sec = ptr_sec->next;
    }
}

void display_list(singlylinkedlist *head) {
  singlylinkedlist *list = head;
  printf("[");
  while (list != NULL) {
    if (list->next == NULL)
      printf("%d", list->data);
    else
      printf("%d, ", list->data);
    list = list->next;
  }
  printf("]\n");
}

void double_display_list(doublylinkedlist *head) {
  doublylinkedlist *list = head;
  printf("[");
  if (list == NULL)
    printf("");
  else {
    while (list != NULL) {
      if (list->next == NULL) {
        printf("%d", list->data);
      } else
        printf("%d, ", list->data);
      list = list->next;
    }
  }
  printf("]\n");
}

void delete_szeros(singlylinkedlist *head) {
  singlylinkedlist *p = head;
  while (p->next != NULL) {
    if (p->next->data == 0)
      p->next = p->next->next;
    else
      p = p->next;
  }
  if (p == 0 && p->next == NULL)
    p = p->next;
}

void delete_dzeros(doublylinkedlist *head) {
  doublylinkedlist *p = head;
  while (p->next != NULL) {
    if (p->next->data == 0)
      p->next = p->next->next;
    else
      p = p->next;
  }
  if (p == 0 && p->next == NULL)
    p = p->next;
}

int main() {
  int index, data2;
  singlylinkedlist *list;
  doublylinkedlist *dhead;

    do {
    printf("How many elements in singlyLinkedList: ");
    scanf("%d", &counter_of_objects);
  } while (counter_of_objects < 1);

  for (int i = 0; i < counter_of_objects; i++) {
    printf("Enter [%i] element: ", i + 1);
    scanf("%d", &data2);
    if (data2 == 0)
      z_counter++;
    if (i == 0)
      list = create(data2);
    else
      add_element(data2, list);
  }
  do {
    printf("Choose the element to be deleted (1 - %i): ",
           counter_of_objects);
    scanf("%d", &index);
  } while (index < 1 || index > counter_of_objects);
  if (index == 1) {
    list = list->next;
    counter_of_objects--;
  } else {
    delete_object(list, index);
    counter_of_objects--;
  }

  printf("\n");
  display_list(list);

  if (z_counter < counter_of_objects) {
    while (list->data == 0)
      list = list->next;
    delete_szeros(list);
  } else {
    while (list->next != NULL)
      list = list->next;
    list = NULL;
  }

  printf("\n");
  display_list(list);

  printf("\n\ndoublyLinkedList: \n\n");
  z_counter = 0;

    do {
    printf("How many elements in doublyLinkedList: ");
    scanf("%d", &counter_of_objects);
  } while (counter_of_objects < 1);

  for (int i = 0; i < counter_of_objects; i++) {
    printf("Enter [%i] element: ", i + 1);
    scanf("%d", &data2);
    if (data2 == 0)
      z_counter++;
    if (i == 0)
      dhead = double_create(data2);
    else
      double_add_element(data2, dhead);
  }

  double_display_list(dhead);

  do {
    printf("Choose the element to be deleted (1 - %i): ", counter_of_objects);
    scanf("%d", &index);
  } while (index < 1 || index > counter_of_objects);
  printf("\n\n");
  if (index == 1 && 1 != counter_of_objects) {
    dhead = dhead->next;
    dhead->prev = NULL;
  } else if (index == 1 && counter_of_objects == 1) {
    dhead = dhead->next;
  } else {
    double_delete_object(dhead, index);
    counter_of_objects--;
  }

  if (z_counter < counter_of_objects && z_counter >= 1) {
    while (dhead->data == 0)
      dhead = dhead->next;
    delete_dzeros(dhead);
    printf("\n");
    double_display_list(dhead);
  } else if (z_counter >= counter_of_objects && z_counter >= 1) {
    while (dhead->data == 0 && z_counter == counter_of_objects) {
      while (dhead->next != NULL)
        dhead = dhead->next;
      dhead = NULL;
      break;
    }
    double_display_list(dhead);
  }
  double_display_list(dhead);
  return 0;
}
