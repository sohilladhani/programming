/* This is a BST implementation in C language */

#include <stdio.h>
#include <stdlib.h>

typedef struct BST_node {
	int data;
	struct BST_node* left;
	struct BST_node* right;
} BST_node;


BST_node* create_BST_node (int data) {
	BST_node* new_BST_node = (BST_node*)(malloc(sizeof(BST_node)));
	new_BST_node->data = data;
	new_BST_node->left = new_BST_node->right = NULL;
	return new_BST_node;
}

BST_node* insert_BST_node_recursive (BST_node* root_ptr, int data) {
	if(root_ptr == NULL) {
		root_ptr = create_BST_node (data);
	} else if (data <= root_ptr->data) {
		root_ptr->left = insert_BST_node_recursive(root_ptr->left, data);
	} else {
		root_ptr->right = insert_BST_node_recursive(root_ptr->right, data);
	}	

	return root_ptr;
}

int search_BST_node_recursive (BST_node* root_ptr, int data) {
	if(root_ptr == NULL) return 0;
	else if(root_ptr->data == data) return 1;
	else if (root_ptr->data > data) search_BST_node_recursive (root_ptr->left, data);
	else search_BST_node_recursive(root_ptr->right, data);	
}

int main () {
	BST_node* root = NULL;
	root = insert_BST_node_recursive(root, 15);
	root = insert_BST_node_recursive(root, 20);
	root = insert_BST_node_recursive(root, 10);	
	root = insert_BST_node_recursive(root, 25);
	printf("%d\n", search_BST_node_recursive(root, 10));
	printf("%d\n", search_BST_node_recursive(root, 25));
	
	return 0;
}

