package edu.miu.aop.aop.service;

import edu.miu.aop.aop.dto.RequestCategoryDTO;
import edu.miu.aop.aop.entity.Category;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/3/2022
 */
public interface CategoryService {

    RequestCategoryDTO save(HttpServletRequest request, RequestCategoryDTO category);

    RequestCategoryDTO update(Long id, RequestCategoryDTO category);

    List<Category> getAllCategory();

    Boolean deleteCategory(Long id);
}
