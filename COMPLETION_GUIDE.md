# HR Frontend Completion Guide

## ✅ COMPLETED:
1. **Dashboard** - With team member section (6 members with avatars)
2. **Regions** - Working with API proxy
3. **Countries** - Working with API proxy (handles `countrieses` pluralization)
4. **Layout** - Modern UI with gradients, animations, sidebar
5. **API Proxy** - All CORS issues resolved

## 🔄 TO COMPLETE:

### Locations (Tanish) - 2 pages needed
### Departments (Nakul) - 2 pages needed  
### Jobs (Samarpit) - 2 pages needed
### Employees (Navya) - 2 pages needed
### Job History (Kartik) - 2 pages needed

## 📋 TEMPLATE PATTERN:

Each page follows this structure:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{layout}">
<head>
    <title>Page Title</title>
</head>
<body>
<div layout:fragment="content">
    <!-- Page content here -->
</div>

<!-- Page-specific scripts -->
<th:block layout:fragment="scripts">
<script>
    console.log('Page script loaded');
    
    // Use API.get() for all API calls
    async function loadData(page = 0) {
        const data = await API.get(`/endpoint?page=${page}&size=20`);
        // Handle pluralization: data._embedded?.entities || data._embedded?.entitieses
    }
    
    // Load on page ready
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', () => setTimeout(loadData, 100));
    } else {
        setTimeout(loadData, 100);
    }
</script>
</th:block>
</body>
</html>
```

## 🔑 KEY POINTS:

1. **Scripts must be in `<th:block layout:fragment="scripts">`** - NOT in content fragment
2. **Use `API.get('/endpoint')` for all API calls** - handles proxy automatically
3. **Handle Spring Data REST pluralization**:
   - countries → `countrieses`
   - employees → `employees`
   - locations → `locations`
   - departments → `departments`
   - jobs → `jobs`

4. **Modern UI elements**:
   - Gradient stat cards
   - Animated tables with `animate__fadeInUp`
   - Search with debounce (300ms)
   - Pagination with chevron icons
   - Loading spinners (4rem size)

## 🎨 TEAM MEMBER COLORS:
- Kartik (Job History): `#667eea → #764ba2`
- Nakul (Departments): `#4facfe → #00f2fe`
- Samarpit (Jobs): `#fa709a → #fee140`
- Navya (Employees): `#f093fb → #f5576c`
- Rupika (Regions/Countries): `#a8edea → #fed6e3`
- Tanish (Locations): `#ffecd2 → #fcb69f`

## 📦 NEXT STEPS:

1. Restart application: `mvn spring-boot:run`
2. Check dashboard - team section should be visible
3. Test Regions and Countries pages
4. Update remaining pages following the pattern above
5. Create detail pages for each entity (Page 2 for each team member)

## 🔗 INTERLINKING:
All pages remain interlinked:
- Regions → Countries → Locations → Departments → Employees
- Jobs → Employees
- Employees → Job History

Each team member's pages are accessible from:
1. Dashboard team section
2. Sidebar navigation
3. Cross-page links (e.g., "View Locations" button in Countries)
