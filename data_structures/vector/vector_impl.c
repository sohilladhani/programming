/*

https://github.com/sohilladhani/coding-interview-university

Implement a vector (mutable array with automatic resizing):

    Practice coding using arrays and pointers, and pointer math to jump to an index instead of using indexing.
    new raw data array with allocated memory
        can allocate int array under the hood, just not use its features
        start with 16, or if starting number is greater, use power of 2 - 16, 32, 64, 128
    size() - number of items
    capacity() - number of items it can hold
    is_empty()
    at(index) - returns item at given index, blows up if index out of bounds
    push(item)
    insert(index, item) - inserts item at index, shifts that index's value and trailing elements to the right
    prepend(item) - can use insert above at index 0
    pop() - remove from end, return value
    delete(index) - delete item at index, shifting all trailing elements left
    remove(item) - looks for value and removes index holding it (even if in multiple places)
    find(item) - looks for value and returns first index with that value, -1 if not found
    resize(new_capacity) // private function
        when you reach capacity, resize to double the size
        when popping an item, if size is 1/4 of capacity, resize to half

Time

    O(1) to add/remove at end (amortized for allocations for more space), index, or update
    O(n) to insert/remove elsewhere

Space

    contiguous in memory, so proximity helps performance
    space needed = (array capacity, which is >= n) * size of item, but even if 2n, still O(n)


*/

#include <stdio.h>
#include <stdlib.h>

#define VECTOR_INIT_CAPACITY 4

typedef struct vector {
	void **elements;
	int size;
	int capacity;
} vector;

void vector_init (vector* v) {
	v->size = 0;
	v->capacity = VECTOR_INIT_CAPACITY;
	v->elements = malloc(sizeof(void *) * v->capacity);
}

int vector_size(vector* v) {
	return v->size;
}

int vector_capacity(vector* v) {
	return v->capacity;
}

int is_empty(vector* v) {
	if(v->size == 0) return 1;
	else return 0;
}

void vector_resize(vector* v, int capacity) {
	void **elements = realloc(v->elements, sizeof(void* ) * capacity);

	if(elements) {
		v->elements = elements;
		v->capacity = capacity;
	}
}

void vector_set(vector* v, int index, void *element) {
	if(index >= 0 && index < v->size) {
		v->elements[index] = element;
	}
}

void vector_pushback(vector* v, void *element) {
	if(v->capacity == v->size) {
		vector_resize(v, v->capacity*2);
	}
	v->elements[v->size++] = element;
}

void vector_shift_right_from_index(vector *v, int index) {
	for(int i = v->size; i > index; i--){
		v->elements[i] = v->elements[i-1];
	}
}

void vector_shift_left_from_index(vector *v, int index) {
	for(int i = index; i < v->size; i++) {
		v->elements[i] = v->elements[i+1];
	}
}

void vector_insert(vector* v, int index, void *element) {
	v->size++;
	if(v->capacity == v->size) {
		vector_resize(v, v->capacity*2);
	}
	
	vector_shift_right_from_index(v, index);

	vector_set(v, index, element);
}

void *vector_at(vector* v, int index) {
	if(index >= 0 && index < v->size) {
		return v->elements[index];
	}
	return NULL;
}

void vector_prepend(vector *v, void *element) {
	vector_insert(v, 0, element);
}

void *vector_pop(vector *v) {
	if(!is_empty(v)) {
		void *popped_element = v->elements[v->size-1];
		v->size--;
		if(v->size < v->capacity/4) {
			vector_resize(v, v->capacity/2);
		}
		return popped_element;
	}
	return NULL;
}

void vector_delete(vector *v, int index) {
	if(index >=0 && index < v->size) {
		if(!is_empty(v) && index != v->size-1) {
		vector_shift_left_from_index(v, index);
	}
		vector_pop(v);	
	}
}

void vector_print_elements(vector *v) {
	for(int i = 0; i < vector_size(v); i++) {
		printf("%s ", (char *) vector_at(v, i));
	}
	printf("\n");
}

void vector_remove(vector *v, void *element) {
	for(int i=0; i < v->size; i++) {
		if(v->elements[i] == element) {
			vector_delete(v, i);
		}
	}
}

int vector_find(vector *v, void *element) {
	for(int i=0; i < v->size; i++) {
		if(v->elements[i] == element) {
			return i;
		}
	}	
	return -1;
}

void vector_free(vector *v) {
	free(v->elements);
}

int main() {
	vector v;
	vector_init(&v);
	int var = 5;
	vector_pushback(&v, "john");
	vector_pushback(&v, "jani");
	vector_pushback(&v, "janardhan");
	vector_pushback(&v, "john");
	vector_pushback(&v, "tara");
	vector_pushback(&v, "rumpum");
	
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));
	printf("vector: ");
	vector_print_elements(&v);

	printf("set value: 'jamloo' at index 4: \n");
	vector_set(&v, 4, "jamloo");
	vector_print_elements(&v);
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));

	printf("insert 'don' at index 2:\n");
	vector_insert(&v, 2, "don");
	vector_print_elements(&v);
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));

	printf("prepend 'dichkiyaooon':\n");
	vector_prepend(&v, "dichkiyaooon");
	vector_print_elements(&v);
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));

	printf("pop operation:\n");
	printf("popped valued: %s\n", vector_pop(&v));
	vector_print_elements(&v);
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));

	printf("delete value at index 3:\n");
	vector_delete(&v, 3);
	vector_print_elements(&v);
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));

	printf("remove 'john':\n");
	vector_remove(&v, "john");
	vector_print_elements(&v);
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));	

	printf("find 'john':\n");
	printf("john is at: %d\n", vector_find(&v, "john"));
	vector_print_elements(&v);
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));		

	printf("find 'jamloo':\n");
	printf("john is at: %d\n", vector_find(&v, "jamloo"));
	vector_print_elements(&v);
	printf("size: %d\n", vector_size(&v));
	printf("capacity: %d\n", vector_capacity(&v));		

	vector_free(&v);

	return 0;
}
